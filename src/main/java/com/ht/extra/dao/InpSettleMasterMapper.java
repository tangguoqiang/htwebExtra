package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.InpSettleMaster;

public interface InpSettleMasterMapper {
    int deleteByPrimaryKey(String rcptNo);

    int insert(InpSettleMaster record);

    int insertSelective(InpSettleMaster record);

    InpSettleMaster selectByPrimaryKey(String rcptNo);

    int updateByPrimaryKeySelective(InpSettleMaster record);

    int updateByPrimaryKey(InpSettleMaster record);
}