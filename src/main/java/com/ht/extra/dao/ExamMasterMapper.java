package com.ht.extra.dao;

import com.ht.extra.pojo.exam.ExamMaster;

import java.util.List;

public interface ExamMasterMapper {
    int deleteByPrimaryKey(String examNo);

    int insert(ExamMaster record);

    int insertSelective(ExamMaster record);

    ExamMaster selectByPrimaryKey(String examNo);

    int updateByPrimaryKeySelective(ExamMaster record);

    int updateByPrimaryKey(ExamMaster record);

    List<ExamMaster> selectExamRepotTwice(String patientId);
}