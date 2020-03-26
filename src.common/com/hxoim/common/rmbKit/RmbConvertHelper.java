package com.hxoim.common.rmbKit;

import com.hxoim.common.rmbKit.models.Family;
import com.hxoim.common.rmbKit.models.RmTable;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class RmbConvertHelper {

    //全局字体
    public final static int fontSize = 12;

    public static XWPFDocument GetRBMDoc(XWPFDocument doc, RmTable rmTable) throws Exception {


        //姓名
        RmbConvertHelper.CellFormat(doc, 1, 0, 1, rmTable.getXingMing());
        //性别
        RmbConvertHelper.CellFormat(doc, 1, 0, 3, rmTable.getXingBie());
        //出生时间
        RmbConvertHelper.CellFormat(doc, 1, 0, 5, rmTable.getChuShengNianYue());
        //照片
        RmbConvertHelper.CellFormaSetPicture(doc, 1, 0, 6, 4, rmTable.getZhaoPianPath());
        //民族
        RmbConvertHelper.CellFormat(doc, 1, 1, 1, rmTable.getMinZu());
        //籍贯
        RmbConvertHelper.CellFormat(doc, 1, 1, 3, rmTable.getJiGuan());
        //出生地
        RmbConvertHelper.CellFormat(doc, 1, 1, 5, rmTable.getChuShengDi());
        //入党时间
        RmbConvertHelper.CellFormat(doc, 1, 2, 1, rmTable.getRuDangShiJian());
        //参工时间
        RmbConvertHelper.CellFormat(doc, 1, 2, 3, rmTable.getCanJiaGongZuoShiJian());
        //健康状况
        RmbConvertHelper.CellFormat(doc, 1, 2, 5, rmTable.getJianKangZhuangKuang());
        //专业技术职务
        RmbConvertHelper.CellFormat(doc, 1, 3, 1, rmTable.getZhuanYeJiShuZhiWu());
        //熟悉专业有何专长
        RmbConvertHelper.CellFormat(doc, 1, 3, 3, rmTable.getShuXiZhuanYeYouHeZhuanChang());
        //全日制学历学位
        String qrzXueLi = rmTable.getQuanRiZhiJiaoYuXueLi();
        String qrzXueWei = rmTable.getQuanRiZhiJiaoYuXueWei();
        if (qrzXueWei != null && !qrzXueWei.equals("")) {
            if (qrzXueLi != null && !qrzXueLi.equals("")) {
                qrzXueLi += "\r" + qrzXueWei;
            } else {
                qrzXueLi = qrzXueWei;
            }
        }
        RmbConvertHelper.CellFormat(doc, 1, 4, 2, qrzXueLi);
        //全日制毕业院校系及专业
        RmbConvertHelper.CellFormat(doc, 1, 4, 4, rmTable.getQrzhiJiaoYuBiYeYuanXiao());

        //在职学历学位
        String zzXueLi = rmTable.getZaiZhiJiaoYuXueLi();
        String zzXueWei = rmTable.getZaiZhiJiaoYuXueWei();
        if (zzXueWei != null && !zzXueWei.equals("")) {
            if (zzXueLi != null && !zzXueLi.equals("")) {
                zzXueLi += "\r" + zzXueWei;
            } else {
                zzXueLi = zzXueWei;
            }
        }
        RmbConvertHelper.CellFormat(doc, 1, 5, 2, zzXueLi);
        //在职毕业院校系及专业
        RmbConvertHelper.CellFormat(doc, 1, 5, 4, rmTable.getZaiZhiJiaoYuBiYeYuanXiao());

        //现任职务
        RmbConvertHelper.CellFormat(doc, 1, 6, 1, rmTable.getXianRenZhiWu());
        //拟任职务
        RmbConvertHelper.CellFormat(doc, 1, 7, 1, rmTable.getNiRenZhiWu());
        //拟免职务
        RmbConvertHelper.CellFormat(doc, 1, 8, 1, rmTable.getNiMianZhiWu());

        if (rmTable.getJianLiList() != null && !rmTable.getJianLiList().isEmpty()) {
            int size = rmTable.getJianLiList().size();
            //为最后一条添加换行符
            String jianLi = rmTable.getJianLiList().get(size - 1);
            rmTable.getJianLiList().set(size - 1, jianLi + "\r");
        }

        //简历
        RmbConvertHelper.CellFormat(doc, 1, 9, 1, rmTable.getJianLiList(), 3, false, 9, -9);

        //奖惩情况
        RmbConvertHelper.CellFormat(doc, 2, 0, 1, rmTable.getJiangChengQingKuang());
        //考核结果
        RmbConvertHelper.CellFormat(doc, 2, 1, 1, rmTable.getNianDuKaoHeJieGuo());
        //任免理由
        RmbConvertHelper.CellFormat(doc, 2, 2, 1, rmTable.getRenMianLiYou());
        //家庭主要成员及社会关系


        List<Family> familyList = rmTable.getJiaTingChengYuanList();
        if (familyList != null && !familyList.isEmpty()) {
            //处理家庭成员单元格
            handleFamilyCell(doc, familyList);

            for (int i = 0; i < (familyList.size() > 10 ? 10 : familyList.size()); i++) {
                Family family = familyList.get(i);
                System.out.println(family.getChengWei());
                //称谓
                RmbConvertHelper.CellFormat(doc, 2, (4 + i), 1, family.getChengWei());
                //姓名
                RmbConvertHelper.CellFormat(doc, 2, (4 + i), 2, family.getXingMing());
                //年龄
                RmbConvertHelper.CellFormat(doc, 2, (4 + i), 3, family.getNianLing());
                //政治面貌
                RmbConvertHelper.CellFormat(doc, 2, (4 + i), 4, family.getZhengZhiMianMao());
                //单位及职务
                RmbConvertHelper.CellFormat(doc, 2, (4 + i), 5, family.getGongZuoDanWeiJiZhiWu());
            }
        }
        //呈报单位年月
        String date = rmTable.getTianBiaoShiJian();
        if (date != null && !"".equals(date)) {
            String[] split = date.split("\\.");
            date = split[0] + " 年 " + Integer.valueOf(split[1]) + " 月 " + Integer.valueOf(split[2]) + " 日 ";
        } else {
            date = "    年  月  日";
        }
        //获取行数
        int rowCount = doc.getTables().get(2).getRows().size();
        RmbConvertHelper.CellFormatSetChengBaoDanWei(doc, 2, rowCount - 3, 1, rmTable.getChengBaoDanWei());
        RmbConvertHelper.CellFormatSetChengBaoDanWeiDate(doc, 2, rowCount - 2, 1, date);

        //处理填表人
        Map<String, Object> map = new HashMap<String, Object>();
        System.err.println(rmTable.getTianBiaoRen());
        map.put("${tianBiaoRen}", rmTable.getTianBiaoRen() == null ? "" : rmTable.getTianBiaoRen());
        handlePerson(doc, map);
        return doc;
    }

    public static XWPFDocument CellFormatSetChengBaoDanWei(XWPFDocument doc, int tableIndex, int rowIndex, int cellIndex, String org) throws Exception {

        if (org == null) {
            return doc;
        }
        XWPFTableCell thisCell = GetTheCell(doc, tableIndex, rowIndex, cellIndex);

        int rows = doc.getTables().get(2).getRows().size();
        XWPFTableRow row = doc.getTables().get(2).getRow(rows - 3);
        //总宽度
        int width = thisCell.getWidth();
        //可以填充的字数
        double numCount = XWPFHelper.GetPtSize(width) / 6;

        double num = org.getBytes("GBK").length;
        if (thisCell != null) {
            XWPFParagraph p = thisCell.addParagraph();

            XWPFRun run = p.createRun();
            run.setFontSize(fontSize);
            run.setText(org);
            if (num < 25) {
                //缩进
                int leftIndent = (int) (width - XWPFHelper.GetDxaSize(13 * fontSize));
                p.setIndentationLeft(leftIndent);
            } else {
                //设置右对齐
                p.setAlignment(ParagraphAlignment.RIGHT);
            }
        }
        return doc;
    }

    /**
     * 处理家庭成员大于7人的情况
     *
     * @param doc        word文档
     * @param familyList 家庭成员集合
     * @return 文档对象
     * @throws Exception 异常
     */
    private static XWPFDocument handleFamilyCell(XWPFDocument doc, List<Family> familyList) throws Exception {
        XWPFTable table = doc.getTables().get(2);
        //表格的总行数
        int rowCount = table.getRows().size();
        //呈报单位最小高度(磅值)36.8498
        double minHeight1 = 13 * 2.8346;
        //呈报日期最小高度(磅值)36.8498
        double minHeight2 = 13 * 2.8346;
        //审批单位意见最小高度(磅值)
        double minHeight3 = 25.5 * 2.8346;
        //数据总行数
        int listCount = familyList.size() > 10 ? 10 : familyList.size();
        //需要在七条基础上新增的行数
        int num = listCount > 7 ? listCount - 7 : 0;
        if (num > 0) {
            //审批机关意见高度
            double height1 = XWPFHelper.GetPtSize(table.getRow(rowCount - 1).getHeight());
            //呈报日期高度
            double height2 = XWPFHelper.GetPtSize(table.getRow(rowCount - 2).getHeight());
            //呈报单位高度
            double height3 = XWPFHelper.GetPtSize(table.getRow(rowCount - 3).getHeight());
            //最后三行可以缩小的最大高度
            double height4 = height1 - minHeight1 + height2 - minHeight2 + height3 - minHeight3;
            //新增行所需要的总高度
            double height5 = height4 / 3 * num;
            //七个家庭成员行的平均高度
            double familyHeight = XWPFHelper.GetPtSize(table.getRow(4).getHeight());
            //当前家庭成员行的平均高度
            familyHeight = (familyHeight * 7 + height5) / listCount;
            height1 -= height5 / 2;
            height3 -= height5 / 2;
            XWPFTableRow row = table.getRow(4);
            //新增行
            for (int i = 0; i < num; i++) {
                copyRow(table, row, 4);
            }

            //设置家庭成员行高
            for (int i = 0; i < familyList.size(); i++) {
                table.getRow(i + 4).setHeight((int) XWPFHelper.GetDxaSize(familyHeight));
            }
            //重新获取行数
            rowCount = table.getRows().size();
            //设置单位审批意见和呈报单位的行高
            table.getRow(rowCount - 1).setHeight((int) XWPFHelper.GetDxaSize(height1));
            table.getRow(rowCount - 3).setHeight((int) XWPFHelper.GetDxaSize(height3));
        }
        return doc;
    }

    public static void copyRow(XWPFTable table, XWPFTableRow sourceRow, int rowIndex) {
        //在表格指定位置新增一行
        XWPFTableRow targetRow = table.insertNewTableRow(rowIndex);
        //复制行属性
        targetRow.getCtRow().setTrPr(sourceRow.getCtRow().getTrPr());
        List<XWPFTableCell> cellList = sourceRow.getTableCells();
        if (null == cellList) {
            return;
        }
        //复制列及其属性和内容
        XWPFTableCell targetCell = null;
        for (XWPFTableCell sourceCell : cellList) {
            targetCell = targetRow.addNewTableCell();
            //列属性
            targetCell.getCTTc().setTcPr(sourceCell.getCTTc().getTcPr());
            //段落属性
            if (sourceCell.getParagraphs() != null && sourceCell.getParagraphs().size() > 0) {
                targetCell.getParagraphs().get(0).getCTP().setPPr(sourceCell.getParagraphs().get(0).getCTP().getPPr());
                if (sourceCell.getParagraphs().get(0).getRuns() != null && sourceCell.getParagraphs().get(0).getRuns().size() > 0) {
                    XWPFRun cellR = targetCell.getParagraphs().get(0).createRun();
                    cellR.setText(sourceCell.getText());
                    cellR.setBold(sourceCell.getParagraphs().get(0).getRuns().get(0).isBold());
                } else {
                    targetCell.setText(sourceCell.getText());
                }
            } else {
                targetCell.setText(sourceCell.getText());
            }
        }
    }

    public static XWPFDocument CellFormat(XWPFDocument doc, int tableIndex, int rowIndex, int cellIndex, List<String> valList)
            throws Exception {
        return CellFormat(doc, tableIndex, rowIndex, cellIndex, valList, 1);
    }

    public static XWPFDocument CellFormat(XWPFDocument doc, int tableIndex, int rowIndex, int cellIndex, String val)
            throws Exception {
        List<String> valList = new ArrayList<String>();
        valList.add(val);
        return CellFormat(doc, tableIndex, rowIndex, cellIndex, valList, 1);
    }

    public static XWPFDocument CellFormat(XWPFDocument doc, int tableIndex, int rowIndex, int cellIndex, List<String> valList, double addLineSpacing) throws Exception {
        return CellFormat(doc, tableIndex, rowIndex, cellIndex, valList, addLineSpacing, false);
    }


    public static XWPFDocument CellFormat(XWPFDocument doc, int tableIndex, int rowIndex, int cellIndex, List<String> valList, double addLineSpacing, Boolean isFilterN) throws Exception {
        return CellFormat(doc, tableIndex, rowIndex, cellIndex, valList, addLineSpacing, isFilterN, 0);
    }

    public static XWPFDocument CellFormat(XWPFDocument doc, int tableIndex, int rowIndex, int cellIndex, List<String> valList, double addLineSpacing,
                                          Boolean isFilterN, double leftIndent) throws Exception {
        return CellFormat(doc, tableIndex, rowIndex, cellIndex, valList, addLineSpacing, isFilterN, leftIndent, 0);
    }

    public static XWPFDocument CellFormat(XWPFDocument doc, int tableIndex, int rowIndex, int cellIndex, List<String> valList, double addLineSpacing,
                                          Boolean isFilterN, double leftIndent, double firstLineIndent) throws Exception {
        //去掉空对象
        if (valList != null && valList.size() > 0) {
            for (Iterator<String> iterator = valList.iterator(); iterator.hasNext(); ) {
                if (iterator.next() == null)
                    iterator.remove();
            }
        }

        if (valList == null || valList.isEmpty()) {
            return doc;
        }
        XWPFTableCell thisCell = GetTheCell(doc, tableIndex, rowIndex, cellIndex);
        //如果为null 不做处理
        if (thisCell == null) {
            return doc;
        }
        //计算尺寸
        int cellWidth = thisCell.getWidth();

        //计算Margin值
        int marginTop = XWPFHelper.GetCellMargin(thisCell, EMarginType.Top);
        int marginRight = XWPFHelper.GetCellMargin(thisCell, EMarginType.Right);
        int marginBottom = XWPFHelper.GetCellMargin(thisCell, EMarginType.Bottom);
        int marginLeft = XWPFHelper.GetCellMargin(thisCell, EMarginType.Left);

        int rowHeight = thisCell.getTableRow().getHeight();

        //转换度量单位
        double rowHeight1 = XWPFHelper.GetPtSize(rowHeight - marginTop - marginBottom);
        double cellWidth1 = XWPFHelper.GetPtSize(cellWidth - marginLeft - marginRight);

        //处理HTML换行
        for (int i = 0; i < valList.size(); i++) {
            String val = valList.get(i);
            val = val.replace("<br />", "\r").replace("<br/>", "\r");
            //word文件规定\r为换行符 数据库中存储的换行为\n
            val = val.replace("\r\n", "\r").replace("\n", "\r");
            valList.set(i, val);
        }

        //获得最适字号
        FitFontSize fitFontSize = new FitFontSize();
        //先按照行距为1处理
        fitFontSize.setAddLineSpacing(1);

        fitFontSize = RmbConvertHelper.GetFontSize(rowHeight1, cellWidth1, valList, 14, fitFontSize
                , isFilterN, leftIndent, firstLineIndent);

        double fontFontSize1 = fitFontSize.getFontSize();
        //设置最适行距
        //如果设定行间距大于1则逐级变大
        if (addLineSpacing > 1) {
            fitFontSize.setAddLineSpacing(2);

            FitFontSize fitFontSize2 = RmbConvertHelper.GetFontSize(rowHeight1, cellWidth1, valList, 14, fitFontSize,
                    isFilterN, leftIndent, firstLineIndent);
            //如果引起字号变小，则说明保持原来字号，行距需要为1
            if (fitFontSize2.getFontSize() <= fontFontSize1) {
                fitFontSize.setFontSize(fontFontSize1);
                fitFontSize.setAddLineSpacing(1);
            } else {
                //如果字号不变，则间距再大一号
                fitFontSize.setAddLineSpacing(3);
                FitFontSize fitFontSize3 = RmbConvertHelper.GetFontSize(rowHeight1, cellWidth1, valList, 14, fitFontSize,
                        isFilterN, leftIndent, firstLineIndent);
                if (fitFontSize3.getFontSize() < fontFontSize1) {
                    fitFontSize.setFontSize(fontFontSize1);
                    fitFontSize.setAddLineSpacing(2);
                } else {
                    fitFontSize.setAddLineSpacing(3);
                }
            }
        }
        //设置值
        SetCellValue(thisCell, valList, fitFontSize, leftIndent, firstLineIndent);
        return doc;
    }

    /**
     * 获得当前单元格
     *
     * @param doc
     * @param tableIndex
     * @param rowIndex
     * @param cellIndex
     * @return
     * @throws Exception
     */
    private static XWPFTableCell GetTheCell(XWPFDocument doc, int tableIndex, int rowIndex, int cellIndex) throws Exception {
        XWPFTableCell thisCell = null;
        List<XWPFTable> tableArray = doc.getTables();
        if (tableArray != null && tableArray.size() > 0) {
            XWPFTable thisTable = tableArray.get(tableIndex);
            List<XWPFTableRow> rowArray = thisTable.getRows();
            if (rowArray != null && rowArray.size() > rowIndex) {
                XWPFTableRow thisRow = rowArray.get(rowIndex);
                List<XWPFTableCell> cellArray = thisRow.getTableCells();
                if (cellArray != null && cellArray.size() > cellIndex) {
                    thisCell = cellArray.get(cellIndex);
                } else {
                    throw new Exception("找不到表格中的行列位置");
                }
            } else {
                throw new Exception("找不到表格中的行列位置");
            }
        } else {
            throw new Exception("找不到表格中的行列位置");
        }
        return thisCell;
    }


    /**
     * 为单元格赋值
     *
     * @param thisCell
     * @param valList
     * @param fitFontSize
     * @param leftIndent      左缩进 磅值
     * @param firstLineIndent 首行缩进 磅值
     */
    private static void SetCellValue(XWPFTableCell thisCell, List<String> valList, FitFontSize fitFontSize, double leftIndent, double firstLineIndent) {


        //默认取第一段的对齐方式 默认居中
        ParagraphAlignment alignment = ParagraphAlignment.CENTER;
        //清除格式
        for (int j = 0; j < thisCell.getParagraphs().size(); j++) {
            XWPFParagraph paragraph = thisCell.getParagraphs().get(j);
            if (j == 0) {
                alignment = paragraph.getAlignment();
            }
            for (int i = 0; i < paragraph.getRuns().size(); i++) {
                paragraph.removeRun(i);
            }
            thisCell.removeParagraph(j);
        }
        if (valList != null && valList.size() > 0) {
            //每个Sring代表一块 首行缩进只第一行起作用，后续的段落不起作用
            for (String val : valList) {
                String[] paragraph = val.split("\r", -1);
                for (int i = 0; i < paragraph.length; i++) {
                    XWPFParagraph paragraph1 = thisCell.addParagraph();
                    //固定行间距
                    paragraph1.setSpacingBetween(fitFontSize.getFontSize() + fitFontSize.getAddLineSpacing(), LineSpacingRule.EXACT);
                    //对齐方式
                    paragraph1.setAlignment(alignment);
                    //左缩进
                    if (leftIndent != 0) {
                        int dxaLeftIndent = (int) XWPFHelper.GetDxaSize(leftIndent * fitFontSize.getFontSize());
                        paragraph1.setIndentationLeft(dxaLeftIndent);
                    }
                    //首行缩进 只处理第一行
                    if (i == 0 && firstLineIndent != 0) {
                        int dxaFirstLineIndent = (int) XWPFHelper.GetDxaSize(firstLineIndent * fitFontSize.getFontSize());
                        paragraph1.setFirstLineIndent(dxaFirstLineIndent);
                    }

                    //添加run
                    XWPFRun run = paragraph1.createRun();
                    run.setFontFamily("宋体");
                    double fontSize = fitFontSize.getFontSize();
                    XWPFHelper.SetXWPFRunFontSize(run, fontSize);
                    run.setText(paragraph[i].replace("\n", ""));
                }
            }
        }

    }


    /**
     * 获得最适字号，范围7.5-14
     *
     * @param fontAreaHeight
     * @param fontAreaWidth
     * @param valList
     * @param maxFontSize
     * @param fitFontSize
     * @param isFilterN
     * @param leftIndent
     * @param firstLineIndent
     * @return
     * @throws Exception
     */
    public static FitFontSize GetFontSize(double fontAreaHeight, double fontAreaWidth, List<String> valList, double maxFontSize, FitFontSize fitFontSize,
                                          Boolean isFilterN, double leftIndent, double firstLineIndent) throws Exception {

        if (fitFontSize == null)
            fitFontSize = new FitFontSize();
        fitFontSize.setLineCount(1);
        //if (maxFontSize >= 14 && IsFontSizeFit(fontAreaHeight, fontAreaWidth - 7 * textIndentCharCount, val, 14, out lineCount, addLineSpacing, isFilterN))
        //{
        //    return 14;
        //}
        //else
        if (maxFontSize >= 12) {
            fitFontSize.setFontSize(12);
            fitFontSize = IsFontSizeFit(fontAreaHeight, fontAreaWidth, valList, fitFontSize, isFilterN, leftIndent, firstLineIndent);
        }
        if (!fitFontSize.isFitAble() && maxFontSize >= 11.5) {
            fitFontSize.setFontSize(11.5);
            fitFontSize = IsFontSizeFit(fontAreaHeight, fontAreaWidth, valList, fitFontSize, isFilterN, leftIndent, firstLineIndent);
        }
        if (!fitFontSize.isFitAble() && maxFontSize >= 11) {
            fitFontSize.setFontSize(11);
            fitFontSize = IsFontSizeFit(fontAreaHeight, fontAreaWidth, valList, fitFontSize, isFilterN, leftIndent, firstLineIndent);
        }
        if (!fitFontSize.isFitAble() && maxFontSize >= 10.5) {
            fitFontSize.setFontSize(10.5);
            fitFontSize = IsFontSizeFit(fontAreaHeight, fontAreaWidth, valList, fitFontSize, isFilterN, leftIndent, firstLineIndent);
        }
        if (!fitFontSize.isFitAble() && maxFontSize >= 10) {
            fitFontSize.setFontSize(10);
            fitFontSize = IsFontSizeFit(fontAreaHeight, fontAreaWidth, valList, fitFontSize, isFilterN, leftIndent, firstLineIndent);
        }
        if (!fitFontSize.isFitAble() && maxFontSize >= 9.5) {
            fitFontSize.setFontSize(9.5);
            fitFontSize = IsFontSizeFit(fontAreaHeight, fontAreaWidth, valList, fitFontSize, isFilterN, leftIndent, firstLineIndent);
        }
        if (!fitFontSize.isFitAble() && maxFontSize >= 9) {
            fitFontSize.setFontSize(9);
            fitFontSize = IsFontSizeFit(fontAreaHeight, fontAreaWidth, valList, fitFontSize, isFilterN, leftIndent, firstLineIndent);
        }
        if (!fitFontSize.isFitAble() && maxFontSize >= 8.5) {
            fitFontSize.setFontSize(8.5);
            fitFontSize = IsFontSizeFit(fontAreaHeight, fontAreaWidth, valList, fitFontSize, isFilterN, leftIndent, firstLineIndent);
        }
        if (!fitFontSize.isFitAble() && maxFontSize >= 8) {
            fitFontSize.setFontSize(8);
            fitFontSize = IsFontSizeFit(fontAreaHeight, fontAreaWidth, valList, fitFontSize, isFilterN, leftIndent, firstLineIndent);
        }
        if (!fitFontSize.isFitAble()) {
            fitFontSize.setFontSize(7.5);
        }
        return fitFontSize;
    }

    /**
     * @param fontAreaHeight
     * @param fontAreaWidth
     * @param valList
     * @param fitFontSize
     * @param isFilterN      过滤换行符 过滤后将val当文字无换行的文字处理
     * @return
     */
    private static FitFontSize IsFontSizeFit(double fontAreaHeight, double fontAreaWidth, List<String> valList, FitFontSize fitFontSize, Boolean isFilterN, double leftIndent, double firstLineIndent) throws Exception {

        if (valList != null && valList.size() > 0) {

        } else {
            return fitFontSize;
        }

        double fontsize = fitFontSize.getFontSize();

        //总行数
        int lineCount = 0;
        //多行作为块状文本，行间距
        for (int l = 0; l < valList.size(); l++) {
            //获得第一块的值
            String val = valList.get(l);
            //过滤掉换行符
            if (isFilterN) {
                val = val.replace("\r", "").replace("\n", "");
            }
            //每个换行一个段落
            String[] array = val.split("\r", -1);

            for (int i = 0; i < array.length; i++) {
                //新的一行
                lineCount++;

                //宽度初始化为
                double lineWidth = 0;

                //第一行初始化宽度，0-左缩进-首行缩进
                if (i == 0) {
                    double _firstLineIndent = 0 - leftIndent - firstLineIndent;
                    lineWidth += _firstLineIndent * fitFontSize.getFontSize();
                } else {
                    //左缩进处理
                    lineWidth += leftIndent * fitFontSize.getFontSize();
                }

                //该行的内容
                String singleLineContent = array[i].replace("\n", "").replace("\r", "");

                char[] charArray = singleLineContent.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    String thisChar = charArray[j] + "";
                    int charLength = thisChar.getBytes("GBK").length;

                    lineWidth += (double) (charLength * fontsize / 2);
                    if (lineWidth > fontAreaWidth) {
                        lineCount++;
                        //指针向前移，将当前指针的字符用作下一行的开始
                        j--;
                        lineWidth = 0;
                        //左缩进处理
                        lineWidth += leftIndent * fitFontSize.getFontSize();
                    }
                }
            }
        }


        if (lineCount * (fontsize + fitFontSize.getAddLineSpacing()) > fontAreaHeight) {
            fitFontSize.setFitAble(false);
        } else {
            fitFontSize.setFitAble(true);
            fitFontSize.setLineCount(lineCount);
        }

        return fitFontSize;
    }

    /**
     * @param fontAreaHeight
     * @param fontAreaWidth
     * @param val
     * @param fitFontSize
     * @param addLineSpacing
     * @param isFilterN      过滤换行符 过滤后将val当文字无换行的文字处理
     * @return
     */
    private static FitFontSize IsFontSizeFit(double fontAreaHeight, double fontAreaWidth, String val, FitFontSize fitFontSize,
                                             double addLineSpacing, Boolean isFilterN) throws Exception {
        if (StringUtility.IsNullOrEmpty(val)) {
            return fitFontSize;
        }

        double fontsize = fitFontSize.getFontSize();

        //过滤掉换行符
        if (isFilterN)
            val = val.replace("\r", "").replace("\n", "");

        String[] array = val.split("\r");
        //总行数
        int lineCount = 0;
        for (int i = 0; i < array.length; i++) {
            //新的一行
            lineCount++;
            //宽度初始化为0
            double lineWidth = 0;

            //该行的内容
            String singleLineContent = array[i].replace("\n", "");

            char[] charArray = singleLineContent.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                String thisChar = charArray[j] + "";
                int charLength = thisChar.getBytes("GBK").length;

                lineWidth += (double) (charLength * fontsize / 2);
                if (lineWidth > fontAreaWidth) {
                    lineCount++;
                    //指针向前移，将当前指针的字符用作下一行的开始
                    j--;
                    lineWidth = 0;
                }
            }
        }

        if (lineCount * (fontsize + addLineSpacing) > fontAreaHeight) {
            fitFontSize.setFitAble(false);
        } else {
            fitFontSize.setFitAble(true);
        }

        return fitFontSize;
    }


    /**
     * 设置照片
     *
     * @param doc
     * @param tableIndex
     * @param rowIndex
     * @param cellIndex
     * @param rowsPan
     * @param imgFilePath
     * @return
     * @throws Exception
     */
    public static XWPFDocument CellFormaSetPicture(XWPFDocument doc, int tableIndex, int rowIndex, int cellIndex, int rowsPan, String imgFilePath) throws Exception {
        int fileFormat = 0;
        if (imgFilePath == null || "".equals(imgFilePath)) {
            return doc;
        }
        //判断格式
        if (imgFilePath.endsWith(".emf")) fileFormat = XWPFDocument.PICTURE_TYPE_EMF;
        else if (imgFilePath.endsWith(".wmf")) fileFormat = XWPFDocument.PICTURE_TYPE_WMF;
        else if (imgFilePath.endsWith(".pict")) fileFormat = XWPFDocument.PICTURE_TYPE_PICT;
        else if (imgFilePath.endsWith(".jpeg") || imgFilePath.endsWith(".jpg"))
            fileFormat = XWPFDocument.PICTURE_TYPE_JPEG;
        else if (imgFilePath.endsWith(".png")) fileFormat = XWPFDocument.PICTURE_TYPE_PNG;
        else if (imgFilePath.endsWith(".dib")) fileFormat = XWPFDocument.PICTURE_TYPE_DIB;
        else if (imgFilePath.endsWith(".gif")) fileFormat = XWPFDocument.PICTURE_TYPE_GIF;
        else if (imgFilePath.endsWith(".tiff")) fileFormat = XWPFDocument.PICTURE_TYPE_TIFF;
        else if (imgFilePath.endsWith(".eps")) fileFormat = XWPFDocument.PICTURE_TYPE_EPS;
        else if (imgFilePath.endsWith(".bmp")) fileFormat = XWPFDocument.PICTURE_TYPE_BMP;
        else if (imgFilePath.endsWith(".wpg")) fileFormat = XWPFDocument.PICTURE_TYPE_WPG;
        else {
            System.err.println("Unsupported picture: " + imgFilePath +
                    ". Expected emf|wmf|pict|jpeg|png|dib|gif|tiff|eps|bmp|wpg");
        }
        CellFormaSetPicture(doc, tableIndex, rowIndex, cellIndex, rowsPan, new FileInputStream(imgFilePath)
                , fileFormat, imgFilePath);
        return doc;
    }


    public static XWPFDocument CellFormaSetPicture(XWPFDocument doc, int tableIndex, int rowIndex, int cellIndex, int rowsPan,
                                                   FileInputStream picFileStream, int fileFormat, String fileName) throws Exception {
        XWPFTableCell picCell = GetTheCell(doc, tableIndex, rowIndex, cellIndex);
        if (picCell != null) {
            //清除格式
            for (int j = 0; j < picCell.getParagraphs().size(); j++) {
                XWPFParagraph paragraph = picCell.getParagraphs().get(j);

                for (int i = 0; i < paragraph.getRuns().size(); i++) {
                    paragraph.removeRun(i);
                }
                picCell.removeParagraph(j);
            }

            //获得单元格高度
            List<XWPFTableRow> tableRows = picCell.getTableRow().getTable().getRows();
            int height = 0;
            for (int i = 0; i < rowsPan; i++) {
                height += tableRows.get(rowIndex + i).getHeight();
            }

            //获得单元格宽度
            int width = picCell.getWidth();

            //度量转换
            int height1 = Units.TwipsToEMU((short) height);
            int width1 = Units.TwipsToEMU((short) width);

            XWPFParagraph picParagraph = picCell.addParagraph();
            XWPFRun r = picParagraph.createRun();
            r.addPicture(picFileStream, fileFormat, fileName, width1, height1);
        }
        return doc;
    }


    /**
     * 设置呈报单位的生成时间
     *
     * @param doc
     * @param tableIndex
     * @param rowIndex
     * @param cellIndex
     * @param DateStr
     * @return
     * @throws Exception
     */
    public static XWPFDocument CellFormatSetChengBaoDanWeiDate(XWPFDocument doc, int tableIndex, int rowIndex, int cellIndex, String DateStr) throws Exception {
        XWPFTableCell thisCell = GetTheCell(doc, tableIndex, rowIndex, cellIndex);
        if (thisCell != null) {
            //获得第二个段落
            List<XWPFParagraph> paragraphsList = thisCell.getParagraphs();
            if (paragraphsList != null && paragraphsList.size() > 0) {
                XWPFParagraph paragraph = paragraphsList.get(0);
                XWPFRun run = paragraph.createRun();
                run.setText(DateStr);
                XWPFHelper.SetXWPFRunFontSize(run, 12);
            }
        }
        return doc;
    }

    /**
     * 替换段落中的指定文字
     */
    public static void handlePerson(XWPFDocument document, Map<String, Object> map) {
        Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
        while (itPara.hasNext()) {
            XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
            List<XWPFRun> runs = paragraph.getRuns();
            Set<String> set = map.keySet();
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                TextSegment textSegment = paragraph.searchText(key, new PositionInParagraph());
                if (textSegment != null) {
                    int beginRun = textSegment.getBeginRun();
                    int endRun = textSegment.getEndRun();
                    System.out.println(beginRun + " " + endRun);
                    if (beginRun == endRun) {
                        XWPFRun run = runs.get(beginRun);
                        String runText = run.getText(0);
                        System.out.println("runText:" + runText);
                        String replaced = runText.replace(key, map.get(key).toString());
                        run.setText(replaced, 0);
                    } else {
                        StringBuilder b = new StringBuilder();
                        for (int runPos = beginRun; runPos <= endRun; runPos++) {
                            XWPFRun run = runs.get(runPos);
                            b.append(run.getText(0));
                        }
                        String connectedRuns = b.toString();
                        String replaced = connectedRuns.replace(key, map.get(key).toString());

                        XWPFRun partOne = runs.get(beginRun);
                        partOne.setText(replaced, 0);
                        for (int runPos = beginRun + 1; runPos <= endRun; runPos++) {
                            XWPFRun partNext = runs.get(runPos);
                            partNext.setText("", 0);
                        }
                    }
                }
            }
        }
    }

    /****
     * word插入图片，暂时不用
     * @param doc
     * @param paragraph
     * @param imagePaths 要写入的图片的路径数组
     */
    private static void InsertImage(XWPFDocument doc, XWPFParagraph paragraph, String[] imagePaths, int width, int height)
            throws IOException, InvalidFormatException {
        XWPFRun r = paragraph.createRun();
        for (String imgFile : imagePaths) {
            int format;
            if (imgFile.endsWith(".emf")) format = XWPFDocument.PICTURE_TYPE_EMF;
            else if (imgFile.endsWith(".wmf")) format = XWPFDocument.PICTURE_TYPE_WMF;
            else if (imgFile.endsWith(".pict")) format = XWPFDocument.PICTURE_TYPE_PICT;
            else if (imgFile.endsWith(".jpeg") || imgFile.endsWith(".jpg")) format = XWPFDocument.PICTURE_TYPE_JPEG;
            else if (imgFile.endsWith(".png")) format = XWPFDocument.PICTURE_TYPE_PNG;
            else if (imgFile.endsWith(".dib")) format = XWPFDocument.PICTURE_TYPE_DIB;
            else if (imgFile.endsWith(".gif")) format = XWPFDocument.PICTURE_TYPE_GIF;
            else if (imgFile.endsWith(".tiff")) format = XWPFDocument.PICTURE_TYPE_TIFF;
            else if (imgFile.endsWith(".eps")) format = XWPFDocument.PICTURE_TYPE_EPS;
            else if (imgFile.endsWith(".bmp")) format = XWPFDocument.PICTURE_TYPE_BMP;
            else if (imgFile.endsWith(".wpg")) format = XWPFDocument.PICTURE_TYPE_WPG;
            else {
                System.err.println("Unsupported picture: " + imgFile +
                        ". Expected emf|wmf|pict|jpeg|png|dib|gif|tiff|eps|bmp|wpg");
                continue;
            }
            r.addPicture(new FileInputStream(imgFile), format, imgFile, width, height);
        }
    }
}
