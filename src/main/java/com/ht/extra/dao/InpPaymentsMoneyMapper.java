package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.InpPaymentsMoney;
import com.ht.extra.pojo.inpbill.InpPaymentsMoneyKey;

public interface InpPaymentsMoneyMapper {
    int deleteByPrimaryKey(InpPaymentsMoneyKey key);

    int insert(InpPaymentsMoney record);

    int insertSelective(InpPaymentsMoney record);

    InpPaymentsMoney selectByPrimaryKey(InpPaymentsMoneyKey key);

    int updateByPrimaryKeySelective(InpPaymentsMoney record);

    int updateByPrimaryKey(InpPaymentsMoney record);
}