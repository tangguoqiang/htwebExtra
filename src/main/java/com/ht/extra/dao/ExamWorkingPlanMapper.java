package com.ht.extra.dao;

import com.ht.extra.pojo.exam.ExamWorkingPlan;
import com.ht.extra.pojo.exam.ExamWorkingPlanKey;

public interface ExamWorkingPlanMapper {
    int deleteByPrimaryKey(ExamWorkingPlanKey key);

    int insert(ExamWorkingPlan record);

    int insertSelective(ExamWorkingPlan record);

    ExamWorkingPlan selectByPrimaryKey(ExamWorkingPlanKey key);

    int updateByPrimaryKeySelective(ExamWorkingPlan record);

    int updateByPrimaryKey(ExamWorkingPlan record);
}