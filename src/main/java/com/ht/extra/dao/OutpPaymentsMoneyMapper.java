package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.OutpPaymentsMoney;
import com.ht.extra.pojo.outpbill.OutpPaymentsMoneyKey;

import java.util.List;

public interface OutpPaymentsMoneyMapper {
    int deleteByPrimaryKey(OutpPaymentsMoneyKey key);

    int insert(OutpPaymentsMoney record);

    int insertSelective(OutpPaymentsMoney record);

    OutpPaymentsMoney selectByPrimaryKey(OutpPaymentsMoneyKey key);

    int updateByPrimaryKeySelective(OutpPaymentsMoney record);

    int updateByPrimaryKey(OutpPaymentsMoney record);

    List<OutpPaymentsMoney> selectByRcptNo(String repoNo);
}