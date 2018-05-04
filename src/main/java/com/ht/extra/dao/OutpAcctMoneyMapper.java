package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.OutpAcctMoney;
import com.ht.extra.pojo.outpbill.OutpAcctMoneyKey;

public interface OutpAcctMoneyMapper {
    int deleteByPrimaryKey(OutpAcctMoneyKey key);

    int insert(OutpAcctMoney record);

    int insertSelective(OutpAcctMoney record);

    OutpAcctMoney selectByPrimaryKey(OutpAcctMoneyKey key);

    int updateByPrimaryKeySelective(OutpAcctMoney record);

    int updateByPrimaryKey(OutpAcctMoney record);
}