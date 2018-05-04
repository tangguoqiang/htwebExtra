package com.ht.extra.dao;

import com.ht.extra.pojo.comm.GradeOfTitleDict;

public interface GradeOfTitleDictMapper {
    int deleteByPrimaryKey(String gradeName);

    int insert(GradeOfTitleDict record);

    int insertSelective(GradeOfTitleDict record);

    GradeOfTitleDict selectByPrimaryKey(String gradeName);

    int updateByPrimaryKeySelective(GradeOfTitleDict record);

    int updateByPrimaryKey(GradeOfTitleDict record);
}