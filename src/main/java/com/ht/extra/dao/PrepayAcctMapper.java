package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.PrepayAcct;

public interface PrepayAcctMapper {
    int deleteByPrimaryKey(String acctNo);

    int insert(PrepayAcct record);

    int insertSelective(PrepayAcct record);

    PrepayAcct selectByPrimaryKey(String acctNo);

    int updateByPrimaryKeySelective(PrepayAcct record);

    int updateByPrimaryKey(PrepayAcct record);
}