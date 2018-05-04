package com.ht.extra.dao;

import com.ht.extra.pojo.comm.UnitTypeDict;

public interface UnitTypeDictMapper {
    int deleteByPrimaryKey(String unitTypeCode);

    int insert(UnitTypeDict record);

    int insertSelective(UnitTypeDict record);

    UnitTypeDict selectByPrimaryKey(String unitTypeCode);

    int updateByPrimaryKeySelective(UnitTypeDict record);

    int updateByPrimaryKey(UnitTypeDict record);
}