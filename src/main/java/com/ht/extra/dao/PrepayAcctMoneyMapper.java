package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.PrepayAcctMoney;
import com.ht.extra.pojo.inpbill.PrepayAcctMoneyKey;

public interface PrepayAcctMoneyMapper {
    int deleteByPrimaryKey(PrepayAcctMoneyKey key);

    int insert(PrepayAcctMoney record);

    int insertSelective(PrepayAcctMoney record);

    PrepayAcctMoney selectByPrimaryKey(PrepayAcctMoneyKey key);

    int updateByPrimaryKeySelective(PrepayAcctMoney record);

    int updateByPrimaryKey(PrepayAcctMoney record);
}