package com.ht.extra.dao;

import com.ht.extra.pojo.comm.GradeOfDutyDict;

public interface GradeOfDutyDictMapper {
    int deleteByPrimaryKey(String gradeName);

    int insert(GradeOfDutyDict record);

    int insertSelective(GradeOfDutyDict record);

    GradeOfDutyDict selectByPrimaryKey(String gradeName);

    int updateByPrimaryKeySelective(GradeOfDutyDict record);

    int updateByPrimaryKey(GradeOfDutyDict record);
}