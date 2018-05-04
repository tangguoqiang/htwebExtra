package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ExamResultStatusDict;

public interface ExamResultStatusDictMapper {
    int deleteByPrimaryKey(String examResultStatusCode);

    int insert(ExamResultStatusDict record);

    int insertSelective(ExamResultStatusDict record);

    ExamResultStatusDict selectByPrimaryKey(String examResultStatusCode);

    int updateByPrimaryKeySelective(ExamResultStatusDict record);

    int updateByPrimaryKey(ExamResultStatusDict record);
}