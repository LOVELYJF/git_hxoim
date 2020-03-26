package com.hxoim.common.rmbKit;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****
 * 合并word文档
 * @author Administrator
 *
 * 上午10:53:44 2018年8月20日
 */
public class MergeDOC {

    public static void main(String[] args) throws Exception {
//		InputStream in1 = null;
//		InputStream in2 = null;
//		OPCPackage src1Package = null;
//		OPCPackage src2Package = null;
//
//		OutputStream dest = new FileOutputStream("G:\\dest.docx");
//		try {
//			in1 = new FileInputStream("G:\\戴某某的任免表.docx");
//			in2 = new FileInputStream("G:\\王老五的任免表.docx");
//			src1Package = OPCPackage.open(in1);
//			src2Package = OPCPackage.open(in2);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		XWPFDocument src1Document = new XWPFDocument(src1Package);
//		CTBody src1Body = src1Document.getDocument().getBody();
//		XWPFDocument src2Document = new XWPFDocument(src2Package);
//		CTBody src2Body = src2Document.getDocument().getBody();
//		appendBody(src1Body, src2Body);
//		src1Document.write(dest);
        List<String> list = new ArrayList();
        list.add("D:\\TEST\\秦川的任免审批表.docx");
        list.add("D:\\TEST\\翁某某的任免审批表.docx");
        list.add("D:\\TEST\\翁某某的任免审批表2.docx");
        String outPath = "D:\\TEST\\new.docx";

        mergeDoc(list, outPath);
    }


    /**
     * 合并docx文件
     *
     * @param srcDocxs 需要合并的目标docx文件
     * @param destDocx 合并后的docx输出文件
     */
    public static void mergeDoc(List<String> srcDocxs, String destDocx) {
        List<File> list = new ArrayList<>();
        if (srcDocxs != null && !srcDocxs.isEmpty()) {
            for (String srcDocx : srcDocxs) {
                list.add(new File(srcDocx));
            }
            if (destDocx != null && !"".equals(destDocx)) {
                mergeDoc(list, new File(destDocx));
            }
        }
    }

    /**
     * 合并docx文件
     *
     * @param srcDocxs 需要合并的目标docx文件
     * @param destDocx 合并后的docx输出文件
     */
    public static void mergeDoc(List<File> srcDocxs, File destDocx) {
        OutputStream dest = null;
        List<OPCPackage> opcpList = new ArrayList<OPCPackage>();
        int length = null == srcDocxs ? 0 : srcDocxs.size();
        /**
         * 循环获取每个docx文件的OPCPackage对象
         */
        for (int i = 0; i < length; i++) {
            File doc = srcDocxs.get(i);
            OPCPackage srcPackage = null;
            try {
                srcPackage = OPCPackage.open(doc);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (null != srcPackage) {
                opcpList.add(srcPackage);
            }
        }
        int opcpSize = opcpList.size();
        //获取的OPCPackage对象大于0时，执行合并操作
        if (opcpSize > 0) {
            try {
                dest = new FileOutputStream(destDocx);
                XWPFDocument src1Document = new XWPFDocument(opcpList.get(0));
                //此处分页符相当于回车，多文件组合后会把表格弄错乱
                src1Document.getLastParagraph().createRun().addBreak();
                if (opcpSize > 1) {
                    for (int i = 1; i < opcpSize; i++) {
                        OPCPackage src2Package = opcpList.get(i);
                        XWPFDocument src2Document = new XWPFDocument(src2Package);
                        if (i != (opcpSize - 1)) {
                            src2Document.getLastParagraph().createRun().addBreak();//设置分页符
                        }
                        appendBody(src1Document, src2Document);
                        src2Document.close();
                    }
                }
                //将合并的文档写入目标文件中
                src1Document.write(dest);
                src1Document.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //关闭流
                try {
                    dest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 合并docx文件（文件后没有换行）
     *
     * @param srcDocxs 需要合并的目标docx文件
     * @param destDocx 合并后的docx输出文件
     */
    public static void mergeDocNoBreak(List<File> srcDocxs, File destDocx) {
        OutputStream dest = null;
        List<OPCPackage> opcpList = new ArrayList<OPCPackage>();
        int length = null == srcDocxs ? 0 : srcDocxs.size();
        /**
         * 循环获取每个docx文件的OPCPackage对象
         */
        for (int i = 0; i < length; i++) {
            File doc = srcDocxs.get(i);
            OPCPackage srcPackage = null;
            try {
                srcPackage = OPCPackage.open(doc);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (null != srcPackage) {
                opcpList.add(srcPackage);
            }
        }
        int opcpSize = opcpList.size();
        //获取的OPCPackage对象大于0时，执行合并操作
        if (opcpSize > 0) {
            try {
                dest = new FileOutputStream(destDocx);
                XWPFDocument src1Document = new XWPFDocument(opcpList.get(0));
                if (opcpSize > 1) {
                    for (int i = 1; i < opcpSize; i++) {
                        OPCPackage src2Package = opcpList.get(i);
                        XWPFDocument src2Document = new XWPFDocument(src2Package);
                        appendBody(src1Document, src2Document);
                        src2Document.close();
                    }
                }
                //将合并的文档写入目标文件中
                src1Document.write(dest);
                src1Document.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //关闭流
                try {
                    dest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //合并处理图片
    public static void appendBody(XWPFDocument src, XWPFDocument append) throws Exception {
        CTBody src1Body = src.getDocument().getBody();
        CTBody src2Body = append.getDocument().getBody();
        List<XWPFPictureData> allPictures = append.getAllPictures();
        // 记录图片合并前及合并后的ID  
        Map<String, String> picMap = new HashMap<String, String>();
        if (allPictures != null && allPictures.size() > 0) {
            for (XWPFPictureData picture : allPictures) {
                String before = append.getRelationId(picture);
                //将原文档中的图片加入到目标文档中
                String after = src.addPictureData(picture.getData(), Document.PICTURE_TYPE_JPEG);
                picMap.put(before, after);
            }
        }
        appendBody(src1Body, src2Body, picMap);
    }

    private static void appendBody(CTBody src, CTBody append, Map<String, String> picMap) throws Exception {
        XmlOptions optionsOuter = new XmlOptions();
        optionsOuter.setSaveOuter();
        String appendString = append.xmlText(optionsOuter);
        String srcString = src.xmlText();
        String prefix = srcString.substring(0, srcString.indexOf(">") + 1);
        String mainPart = srcString.substring(srcString.indexOf(">") + 1, srcString.lastIndexOf("<"));
        String sufix = srcString.substring(srcString.lastIndexOf("<"));
        String addPart = appendString.substring(appendString.indexOf(">") + 1, appendString.lastIndexOf("<"));
        if (picMap != null && !picMap.isEmpty()) {
            //对xml字符串中图片ID进行替换  
            for (Map.Entry<String, String> set : picMap.entrySet()) {
                addPart = addPart.replace(set.getKey(), set.getValue());
            }
        }
        //将两个文档的xml内容进行拼接  
        CTBody makeBody = CTBody.Factory.parse(prefix + mainPart + addPart + sufix);
        src.set(makeBody);
    }


}
