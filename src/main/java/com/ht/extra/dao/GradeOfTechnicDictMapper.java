package com.ht.extra.dao;

import com.ht.extra.pojo.comm.GradeOfTechnicDict;

public interface GradeOfTechnicDictMapper {
    int deleteByPrimaryKey(String gradeName);

    int insert(GradeOfTechnicDict record);

    int insertSelective(GradeOfTechnicDict record);

    GradeOfTechnicDict selectByPrimaryKey(String gradeName);

    int updateByPrimaryKeySelective(GradeOfTechnicDict record);

    int updateByPrimaryKey(GradeOfTechnicDict record);
}