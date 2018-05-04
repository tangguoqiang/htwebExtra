package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.RegistAcctMoney;
import com.ht.extra.pojo.outpadm.RegistAcctMoneyKey;

public interface RegistAcctMoneyMapper {
    int deleteByPrimaryKey(RegistAcctMoneyKey key);

    int insert(RegistAcctMoney record);

    int insertSelective(RegistAcctMoney record);

    RegistAcctMoney selectByPrimaryKey(RegistAcctMoneyKey key);

    int updateByPrimaryKeySelective(RegistAcctMoney record);

    int updateByPrimaryKey(RegistAcctMoney record);
}