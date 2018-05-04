package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ChargeTypeDict;

public interface ChargeTypeDictMapper {
    int deleteByPrimaryKey(String chargeTypeName);

    int insert(ChargeTypeDict record);

    int insertSelective(ChargeTypeDict record);

    ChargeTypeDict selectByPrimaryKey(String chargeTypeName);

    int updateByPrimaryKeySelective(ChargeTypeDict record);

    int updateByPrimaryKey(ChargeTypeDict record);
}