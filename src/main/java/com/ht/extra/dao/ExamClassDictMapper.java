package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ExamClassDict;

public interface ExamClassDictMapper {
    int deleteByPrimaryKey(String examClassName);

    int insert(ExamClassDict record);

    int insertSelective(ExamClassDict record);

    ExamClassDict selectByPrimaryKey(String examClassName);

    int updateByPrimaryKeySelective(ExamClassDict record);

    int updateByPrimaryKey(ExamClassDict record);
}