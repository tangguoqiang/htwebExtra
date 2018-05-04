package com.ht.extra.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/1/10.
 */
public class StringUtil {
    public static String Iso_GBK(String Iso){
        try {
            if(Iso !=null){
                return new String(Iso.getBytes("ISO-8859-1"),"GBK");
            }else{
                return "";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String Utf_Iso(String UTF){
        try {
            if(UTF !=null){
                return new String(UTF.getBytes("GBK"),"ISO-8859-1");
            }else{
                return "";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
