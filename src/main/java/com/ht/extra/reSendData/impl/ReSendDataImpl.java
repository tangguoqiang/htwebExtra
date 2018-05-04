package com.ht.extra.reSendData.impl;

import com.ht.extra.reSendData.ReSendData;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * Created by xps13 on 2017/4/11.
 */
public class ReSendDataImpl implements ReSendData {
    @Override
    public String toSend(String xmlStr) {
        return "123";
    }

    public String invokeService(String xmlStr) {
        String str = "";
        //String serviceURL = "http://221.226.53.205:8084/hdepc/services/hisWebService?wsdl";
        //String serviceURL = "http://10.119.119.117:8084/hdepc/services/hisWebService?wsdl";
        //访问160正式地址
        //String serviceURL = "http://10.119.120.126:8084/hdepc/services/hisWebService?wsdl";
        String serviceURL = getPropertyByName();
        try {
            JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
            org.apache.cxf.endpoint.Client client = dcf.createClient(serviceURL);
            //sayHello 为接口中定义的方法名称   张三为传递的参数   返回一个Object数组
            Object[] objects=client.invoke("requestWS", xmlStr);
            //输出调用结果
            System.out.println("1111");
            str = objects[0].toString();
            System.out.println("str-->"+str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getPropertyByName() {
        String result = "";
        try {
            // 方法一：通过java.util.ResourceBundle读取资源属性文件
            result = java.util.ResourceBundle.getBundle("160WebServicesURL").getString("url");
            System.out.println("160URL:" + result);
        } catch (Exception e) {
            System.out.println("getPropertyByName2 error:");
        }
        return result;
    }
}
