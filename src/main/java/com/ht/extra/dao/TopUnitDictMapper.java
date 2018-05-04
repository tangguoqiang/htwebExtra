package com.ht.extra.dao;

import com.ht.extra.pojo.comm.TopUnitDict;

public interface TopUnitDictMapper {
    int deleteByPrimaryKey(String topUnitCode);

    int insert(TopUnitDict record);

    int insertSelective(TopUnitDict record);

    TopUnitDict selectByPrimaryKey(String topUnitCode);

    int updateByPrimaryKeySelective(TopUnitDict record);

    int updateByPrimaryKey(TopUnitDict record);
}