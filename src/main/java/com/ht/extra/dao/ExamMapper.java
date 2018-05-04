package com.ht.extra.dao;

import com.ht.extra.pojo.lab.Exam;

public interface ExamMapper {
    int deleteByPrimaryKey(Short serialNo);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Short serialNo);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
}