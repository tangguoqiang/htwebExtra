package com.ht.extra.dao;

import com.ht.extra.pojo.exam.ExamSchedule;
import com.ht.extra.pojo.exam.ExamScheduleKey;

public interface ExamScheduleMapper {
    int deleteByPrimaryKey(ExamScheduleKey key);

    int insert(ExamSchedule record);

    int insertSelective(ExamSchedule record);

    ExamSchedule selectByPrimaryKey(ExamScheduleKey key);

    int updateByPrimaryKeySelective(ExamSchedule record);

    int updateByPrimaryKey(ExamSchedule record);
}