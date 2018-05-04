package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OccupationDict;

public interface OccupationDictMapper {
    int deleteByPrimaryKey(String occupationCode);

    int insert(OccupationDict record);

    int insertSelective(OccupationDict record);

    OccupationDict selectByPrimaryKey(String occupationCode);

    int updateByPrimaryKeySelective(OccupationDict record);

    int updateByPrimaryKey(OccupationDict record);
}