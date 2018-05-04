package com.ht.extra.reSendData;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.log4j.Logger;

/**
 * Created by xmcheng on 2017/4/16.
 */
public class AxisReSendData {
    private static Logger logger = Logger.getLogger(AxisReSendData.class);
    public String axisToSend(String xmlStr){
        logger.info("AxisReSendData 入参"+xmlStr);
        return invokeService(xmlStr);
    }

    private String invokeService(String xmlStr) {
        String str = "";
        //String serviceURL = "http://221.226.53.205:8084/hdepc/services/hisWebService?wsdl";
        //String serviceURL = "http://10.119.119.117:8084/hdepc/services/hisWebService?wsdl";
        //访问160正式地址
        String serviceURL = "http://10.119.120.127:8084/hdepc/services/hisWebService?wsdl";
        try {
            JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
            org.apache.cxf.endpoint.Client client = dcf.createClient(serviceURL);
            Object[] objects=client.invoke("requestWS", xmlStr);
            str = objects[0].toString();
            System.out.println("str-->"+str);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("160 返回值："+e.getMessage());
            return e.getMessage();
        }
        logger.info("160返回值："+str);
        return str;
    }
}
