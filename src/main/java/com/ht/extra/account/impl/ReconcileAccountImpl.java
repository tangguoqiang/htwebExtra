package com.ht.extra.account.impl;

import com.alibaba.druid.util.StringUtils;
import com.google.common.collect.Maps;
import com.ht.extra.account.IReconcileAccount;
import com.ht.extra.dao.ReconcileAccountMapper;
import com.ht.extra.pojo.ReconcileAccount;
import com.ht.extra.util.Utils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.ht.extra.util.StringUtil.*;

/**
 * 对账接口实现
 *
 * @author Tang
 */
public class ReconcileAccountImpl implements IReconcileAccount {

    private static Logger logger = Logger.getLogger(ReconcileAccountImpl.class);

    @Resource
    private ReconcileAccountMapper reconcileAccountMapper;

    @Override
    public String reconcileAccount(String xmlStr) {
        logger.info("[对账接口(reconcileAccount)入参 :]" + xmlStr);
        Document document;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String orderDate = root.element("msg_body").element("ORDER_DATE").getTextTrim();

            Document doc = buildDoc(reconcileAccountMapper.reconcileAccount(orderDate, nextDate(orderDate)));

            return doc.asXML();
        } catch (DocumentException e) {
            logger.error("对账接口出错 : {}", e);
            return Utils.getErrorMsg("数据处理出错");
        }
    }

    /**
     * build document
     *
     * @param accounts reconcile accounts
     * @return Document
     */
    private Document buildDoc(List<ReconcileAccount> accounts) {
        Document doc = DocumentHelper.createDocument();
        doc.setXMLEncoding("GBK");
        Element responseRoot = doc.addElement("response");
        int size = 0;
        if (accounts != null) {
            size = accounts.size();
        }

        Map<String, String> udfAttrs = Maps.newHashMap();
        udfAttrs.put("totalrow", size + "");
        buildResponseSuccessHeader(responseRoot, udfAttrs);

        Element dataBody = responseRoot.addElement("msg_body");
        if (size > 0) {
            Element rows;
            int index = 1;
            for (ReconcileAccount account : accounts) {
                rows = dataBody.addElement("rows");
                rows.addElement("ID").setText((index++) + "");
                rows.addElement("RCPT_NO").setText(processNull(account.getRecpNo()));
                rows.addElement("INVOICE_ID").setText(processNull(account.getInvoiceId()));
                rows.addElement("ORDER_ID").setText(processNull(account.getOrderId()));
                rows.addElement("ORDER_DATE").setText(processDate(account.getOrderDate(), "yyyy/MM/dd"));
                rows.addElement("ORDER_TIME").setText(processDate(account.getOrderDate(), "HH:mm:ss"));
                rows.addElement("PAY_NAME").setText(processNull(account.getPayName()));
                rows.addElement("COST").setText(processNull(account.getCost() + ""));
                rows.addElement("STATUS").setText(processNull(account.getStatus()));
                rows.addElement("CARD_NO").setText(processNull(account.getCardNo()));
                rows.addElement("PATIENT_ID").setText(processNull(account.getPatientId()));
                rows.addElement("PATIENT_NAME").setText(processNull(account.getPatientName()));
                rows.addElement("PAY_TYPE").setText(processNull(account.getPayType()));
                rows.addElement("SYSTEM_ID").setText(processNull(account.getSystemId()));
                rows.addElement("SYSTEM_TYPE").setText(processNull(account.getSystemType()));
                rows.addElement("DISTRICT").setText(processNull(account.getDistrict()));
                rows.addElement("PAY_ACCOUNT").setText(processNull(account.getPayAccount()));
                rows.addElement("OPERATE_ID").setText(processNull(account.getOperateId()));
                rows.addElement("DEVICE_ID").setText(processNull(account.getDeviceId()));
                rows.addElement("REMARKS").setText(processNull(account.getRemarks()));
            }
        }
        return doc;
    }

    /**
     * build header of success response
     *
     * @param responseRoot Element
     * @param udfAttrs     user define attributes
     */
    private void buildResponseSuccessHeader(Element responseRoot, Map<String, String> udfAttrs) {
        Element responseHeader = responseRoot.addElement("msg_head");
        responseHeader.addElement("responsecode").setText("1");
        responseHeader.addElement("responsestr").setText("成功");

        if (udfAttrs != null && !udfAttrs.isEmpty()) {
            for (Map.Entry<String, String> entry : udfAttrs.entrySet()) {
                responseHeader.addElement(entry.getKey()).setText(entry.getValue());
            }
        }
    }

    private String processNull(String text) {
        return text == null ? "" : Iso_GBK(text);
    }

    private String processDate(String text, String fromFormat, String toFormat) {
        if (StringUtils.isEmpty(text))
            return "";
        if (StringUtils.isEmpty(fromFormat) || StringUtils.isEmpty(toFormat))
            return text;

        SimpleDateFormat fromSdf = new SimpleDateFormat(fromFormat);
        SimpleDateFormat toSdf = new SimpleDateFormat(toFormat);
        try {
            return toSdf.format(fromSdf.parse(text));
        } catch (ParseException e) {
            return "";
        }
    }

    private String processDate(Date date, String format) {
        if (date == null)
            return "";
        if (StringUtils.isEmpty(format))
            return "";

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    private String nextDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return sdf.format(calendar.getTime());
    }
}
