package com.ht.extra.dao;

import com.ht.extra.pojo.exam.ExamReport;

public interface ExamReportMapper {
    int deleteByPrimaryKey(String examNo);

    int insert(ExamReport record);

    int insertSelective(ExamReport record);

    ExamReport selectByPrimaryKey(String examNo);

    int updateByPrimaryKeySelective(ExamReport record);

    int updateByPrimaryKey(ExamReport record);
}