package com.ht.extra.test.impl;

import com.ht.extra.test.HelloWorld;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * Created by Dell on 2016/12/13.
 */
public class HelloWorldImpl implements HelloWorld {


    @Override
    public String toSend(String xmlStr) {
        System.out.println(xmlStr);
        return xmlStr;
    }

    public String invokeService(String xmlStr) {
        String str = "";
        String serviceURL = "http://221.226.53.205:8084/hdepc/services/hisWebService?wsdl";
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
            return e.getMessage();
        }
        return str;
    }

    public static void main(String[] args) {
        HelloWorldImpl helloWorld = new HelloWorldImpl();
        helloWorld.invokeService("<request>\t<head><key>pay_Comm_RefundFee</key><hospcode></hospcode><token></token>" +
                "<time>20170416154036</time></head><body><hisPayNo>O1000001</hisPayNo><invoiceNo>O1000001</invoiceNo><payTradeNo>4008852001201704157131106422</payTradeNo><payMethod>weixin</payMethod>" +
                "<refundAmt>0.03</refundAmt><refundTime>20170416154036</refundTime><refundMan></refundMan></body></request>");
    }
}
