package com.ht.extra.dao;

import com.ht.extra.pojo.comm.WoundGradeDict;

public interface WoundGradeDictMapper {
    int deleteByPrimaryKey(String woundGradeCode);

    int insert(WoundGradeDict record);

    int insertSelective(WoundGradeDict record);

    WoundGradeDict selectByPrimaryKey(String woundGradeCode);

    int updateByPrimaryKeySelective(WoundGradeDict record);

    int updateByPrimaryKey(WoundGradeDict record);
}