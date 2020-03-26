package com.hxoim.common.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

public class Dom4jUtil {

    /**
     * 传入文件进行解析,返回根节点
     *
     * @param file 文件
     * @return 根节点
     */
    public static Element parseXml(File file)throws Exception {
        //解析xml返回elementIterator
        Element result = null;
        try {
            SAXReader saxReader = new SAXReader();
            Document document = null;
            document = saxReader.read(file);
            if (document == null) {
                throw new NullPointerException("未找到指定文件");
            }
            result = document.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return result;
    }

    /**
           *   传入文件路径进行解析,返回根节点
     *
     * @param path xml文件路径
     * @return 根节点
     */
    public static Element parseXml(String path)throws Exception {
        return parseXml(new File(path));
    }
}
