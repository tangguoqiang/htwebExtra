package com.ht.extra.dao;

import com.ht.extra.pojo.comm.SpecialAreaDict;

public interface SpecialAreaDictMapper {
    int deleteByPrimaryKey(String areaName);

    int insert(SpecialAreaDict record);

    int insertSelective(SpecialAreaDict record);

    SpecialAreaDict selectByPrimaryKey(String areaName);

    int updateByPrimaryKeySelective(SpecialAreaDict record);

    int updateByPrimaryKey(SpecialAreaDict record);
}