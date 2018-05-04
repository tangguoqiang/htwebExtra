package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.InpAcctMaster;

public interface InpAcctMasterMapper {
    int deleteByPrimaryKey(String acctNo);

    int insert(InpAcctMaster record);

    int insertSelective(InpAcctMaster record);

    InpAcctMaster selectByPrimaryKey(String acctNo);

    int updateByPrimaryKeySelective(InpAcctMaster record);

    int updateByPrimaryKey(InpAcctMaster record);
}