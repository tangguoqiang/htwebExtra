package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.InpAcctMoney;
import com.ht.extra.pojo.inpbill.InpAcctMoneyKey;

public interface InpAcctMoneyMapper {
    int deleteByPrimaryKey(InpAcctMoneyKey key);

    int insert(InpAcctMoney record);

    int insertSelective(InpAcctMoney record);

    InpAcctMoney selectByPrimaryKey(InpAcctMoneyKey key);

    int updateByPrimaryKeySelective(InpAcctMoney record);

    int updateByPrimaryKey(InpAcctMoney record);
}