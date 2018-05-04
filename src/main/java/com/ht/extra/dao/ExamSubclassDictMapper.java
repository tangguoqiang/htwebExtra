package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ExamSubclassDict;

public interface ExamSubclassDictMapper {
    int deleteByPrimaryKey(String examSubclassName);

    int insert(ExamSubclassDict record);

    int insertSelective(ExamSubclassDict record);

    ExamSubclassDict selectByPrimaryKey(String examSubclassName);

    int updateByPrimaryKeySelective(ExamSubclassDict record);

    int updateByPrimaryKey(ExamSubclassDict record);
}