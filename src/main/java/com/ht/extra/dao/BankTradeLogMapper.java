package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.BankTradeLog;
import com.ht.extra.pojo.insurance.BankTradeLogKey;

public interface BankTradeLogMapper {
    int deleteByPrimaryKey(BankTradeLogKey key);

    int insert(BankTradeLog record);

    int insertSelective(BankTradeLog record);

    BankTradeLog selectByPrimaryKey(BankTradeLogKey key);

    int updateByPrimaryKeySelective(BankTradeLog record);

    int updateByPrimaryKey(BankTradeLog record);
}