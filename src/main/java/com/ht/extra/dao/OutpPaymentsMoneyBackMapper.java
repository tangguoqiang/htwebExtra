package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.OutpPaymentsMoneyBack;
import com.ht.extra.pojo.outpbill.OutpPaymentsMoneyBackKey;

public interface OutpPaymentsMoneyBackMapper {
    int deleteByPrimaryKey(OutpPaymentsMoneyBackKey key);

    int insert(OutpPaymentsMoneyBack record);

    int insertSelective(OutpPaymentsMoneyBack record);

    OutpPaymentsMoneyBack selectByPrimaryKey(OutpPaymentsMoneyBackKey key);

    int updateByPrimaryKeySelective(OutpPaymentsMoneyBack record);

    int updateByPrimaryKey(OutpPaymentsMoneyBack record);
}