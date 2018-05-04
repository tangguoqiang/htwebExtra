package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.OutpAcctMaster;

public interface OutpAcctMasterMapper {
    int deleteByPrimaryKey(String acctNo);

    int insert(OutpAcctMaster record);

    int insertSelective(OutpAcctMaster record);

    OutpAcctMaster selectByPrimaryKey(String acctNo);

    int updateByPrimaryKeySelective(OutpAcctMaster record);

    int updateByPrimaryKey(OutpAcctMaster record);
}