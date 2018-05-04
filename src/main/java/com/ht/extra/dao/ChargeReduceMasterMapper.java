package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.ChargeReduceMaster;

public interface ChargeReduceMasterMapper {
    int deleteByPrimaryKey(Integer serialNo);

    int insert(ChargeReduceMaster record);

    int insertSelective(ChargeReduceMaster record);

    ChargeReduceMaster selectByPrimaryKey(Integer serialNo);

    int updateByPrimaryKeySelective(ChargeReduceMaster record);

    int updateByPrimaryKey(ChargeReduceMaster record);
}