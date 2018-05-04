package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AccountPriceList81;
import com.ht.extra.pojo.comm.AccountPriceList81Key;

public interface AccountPriceList81Mapper {
    int deleteByPrimaryKey(AccountPriceList81Key key);

    int insert(AccountPriceList81 record);

    int insertSelective(AccountPriceList81 record);

    AccountPriceList81 selectByPrimaryKey(AccountPriceList81Key key);

    int updateByPrimaryKeySelective(AccountPriceList81 record);

    int updateByPrimaryKey(AccountPriceList81 record);
}