package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ExamRptPattern;
import com.ht.extra.pojo.comm.ExamRptPatternKey;

public interface ExamRptPatternMapper {
    int deleteByPrimaryKey(ExamRptPatternKey key);

    int insert(ExamRptPattern record);

    int insertSelective(ExamRptPattern record);

    ExamRptPattern selectByPrimaryKey(ExamRptPatternKey key);

    int updateByPrimaryKeySelective(ExamRptPattern record);

    int updateByPrimaryKey(ExamRptPattern record);
}