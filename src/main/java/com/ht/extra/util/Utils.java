package com.ht.extra.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 共同类
 * @author Tang
 */
public class Utils {

    /**
     * 构造错误返回消息
     * @param desc 描述
     * @return xml document
     */
    public static String getErrorMsg(String desc){
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("response");
        Element head = root.addElement("head");
        head.addElement("result").setText("0");
        head.addElement("desc").setText(desc);
        return doc.asXML();
    }
}
