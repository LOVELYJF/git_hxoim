package com.hxoim.common.rmbKit;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.math.BigInteger;

public class XWPFHelper {

    //1cm=567 缇
    private static final int SIZE_CM = 567;

    //1cm=28.35磅
    private static final double SIZE_CM_PT = 28.35;

    public static void SetXWPFRunFontSize(XWPFRun run, double fontSize) {
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr ctrPR = run.getCTR().addNewRPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure ctSize = ctrPR.isSetSz() ? ctrPR.getSz() : ctrPR.addNewSz();
        BigInteger bint = new BigInteger(Integer.toString((int) (fontSize * 2)));
        ctSize.setVal(bint);
    }

    /**
     * 该单元格是否为Margin单独设置值
     *
     * @param cell
     * @return ture false
     */
    public static boolean IsHasMargin(XWPFTableCell cell) {
        boolean isHasMargin = false;
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr cellProperties = cell.getCTTc().getTcPr();
        //获得属性节点集合
        NodeList nodeList = cellProperties.getDomNode().getChildNodes();
        if (nodeList != null && nodeList.getLength() > 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node thisNode = nodeList.item(i);
                String nodeName = thisNode.getNodeName();
                if (nodeName.equals("w:tcMar")) {
                    isHasMargin = true;
                }
            }
        }
        return isHasMargin;
    }

    /**
     * 获得单元格Margin的Dxa值，如果未对该单元格设置值则返回对应表格Margin的值
     *
     * @param cell
     * @param marginType
     * @return
     */
    public static int GetCellMargin(XWPFTableCell cell, EMarginType marginType) {

        //默认取表格设置的值
        XWPFTable thisTable = cell.getTableRow().getTable();
        int marDxaSize=0;
        if(marginType==EMarginType.Top)
            marDxaSize = thisTable.getCellMarginTop();
        if(marginType==EMarginType.Right)
            marDxaSize = thisTable.getCellMarginRight();
        if(marginType==EMarginType.Bottom)
            marDxaSize = thisTable.getCellMarginBottom();
        if(marginType==EMarginType.Left)
            marDxaSize = thisTable.getCellMarginLeft();

        //如果为该单元格单独设置了Margin则取单元格的值
        //获得该单元格的属性
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr cellProperties = cell.getCTTc().getTcPr();
        //获得属性节点集合
        NodeList nodeList = cellProperties.getDomNode().getChildNodes();
        if (nodeList != null && nodeList.getLength() > 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node thisNode = nodeList.item(i);
                String nodeName = thisNode.getNodeName();
                if (nodeName.equals("w:tcMar")) {
                    //获得子节点
                    NodeList marNodeList = thisNode.getChildNodes();
                    if (marNodeList != null && marNodeList.getLength() > 0) {
                        for (int k = 0; k < marNodeList.getLength(); k++) {
                            Node thisMarNode = marNodeList.item(k);
                            String marNodeName = thisMarNode.getNodeName();
                            if (marNodeName.toUpperCase().equals(("w:" + marginType).toUpperCase())) {
                                String attrValue = thisMarNode.getAttributes().getNamedItem("w:w").getNodeValue();
                                marDxaSize = Integer.parseInt(attrValue);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return marDxaSize;
    }

    /**
     * 将Dxa值转换为磅值
     */
    public static double GetPtSize(int dxaSize) {
        double ptSize = ((double) dxaSize / SIZE_CM) * SIZE_CM_PT;
        return ptSize;
    }

    /**
     * 将磅值转换为Dxa值
     */
    public static double GetDxaSize(double ptSize) {
        double dxaSize = (ptSize / SIZE_CM_PT) * SIZE_CM;
        return dxaSize;
    }
}

