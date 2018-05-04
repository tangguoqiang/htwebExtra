package com.ht.extra.dao;

import com.ht.extra.pojo.comm.UnitInContract;

public interface UnitInContractMapper {
    int deleteByPrimaryKey(String unitCode);

    int insert(UnitInContract record);

    int insertSelective(UnitInContract record);

    UnitInContract selectByPrimaryKey(String unitCode);

    int updateByPrimaryKeySelective(UnitInContract record);

    int updateByPrimaryKey(UnitInContract record);
}