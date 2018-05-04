package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.RegistAcctMaster;

public interface RegistAcctMasterMapper {
    int deleteByPrimaryKey(String acctNo);

    int insert(RegistAcctMaster record);

    int insertSelective(RegistAcctMaster record);

    RegistAcctMaster selectByPrimaryKey(String acctNo);

    int updateByPrimaryKeySelective(RegistAcctMaster record);

    int updateByPrimaryKey(RegistAcctMaster record);
}