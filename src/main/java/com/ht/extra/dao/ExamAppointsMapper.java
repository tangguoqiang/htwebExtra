package com.ht.extra.dao;

import com.ht.extra.pojo.exam.ExamAppoints;

public interface ExamAppointsMapper {
    int deleteByPrimaryKey(String examNo);

    int insert(ExamAppoints record);

    int insertSelective(ExamAppoints record);

    ExamAppoints selectByPrimaryKey(String examNo);

    int updateByPrimaryKeySelective(ExamAppoints record);

    int updateByPrimaryKey(ExamAppoints record);
}