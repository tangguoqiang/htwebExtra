package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.InpBillDetail;
import com.ht.extra.pojo.inpbill.InpBillDetailKey;

import java.util.Date;
import java.util.List;

public interface InpBillDetailMapper {
    int deleteByPrimaryKey(InpBillDetailKey key);

    int insert(InpBillDetail record);

    int insertSelective(InpBillDetail record);

    InpBillDetail selectByPrimaryKey(InpBillDetailKey key);

    int updateByPrimaryKeySelective(InpBillDetail record);

    int updateByPrimaryKey(InpBillDetail record);

    List<InpBillDetail> selectBillingDate(String patientId, short visitId, Date billingData);
}