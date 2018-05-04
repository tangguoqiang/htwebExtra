package com.ht.extra.dao;

import com.ht.extra.pojo.exam.ExamInterval;
import com.ht.extra.pojo.exam.ExamIntervalKey;

public interface ExamIntervalMapper {
    int deleteByPrimaryKey(ExamIntervalKey key);

    int insert(ExamInterval record);

    int insertSelective(ExamInterval record);

    ExamInterval selectByPrimaryKey(ExamIntervalKey key);

    int updateByPrimaryKeySelective(ExamInterval record);

    int updateByPrimaryKey(ExamInterval record);
}