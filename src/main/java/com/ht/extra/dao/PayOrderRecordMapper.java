package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.PayOrderRecord;

import java.util.Date;
import java.util.List;

public interface PayOrderRecordMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(PayOrderRecord record);

    int insertSelective(PayOrderRecord record);

    PayOrderRecord selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(PayOrderRecord record);

    int updateByPrimaryKey(PayOrderRecord record);

    PayOrderRecord selectByVisitDateNo(Date date, String visidNo);

    List<PayOrderRecord> selectByRecordTime(Date bgDate);
}