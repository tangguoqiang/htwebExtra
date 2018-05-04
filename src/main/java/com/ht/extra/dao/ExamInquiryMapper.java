package com.ht.extra.dao;

import com.ht.extra.pojo.exam.ExamInquiry;

public interface ExamInquiryMapper {
    int deleteByPrimaryKey(String examNo);

    int insert(ExamInquiry record);

    int insertSelective(ExamInquiry record);

    ExamInquiry selectByPrimaryKey(String examNo);

    int updateByPrimaryKeySelective(ExamInquiry record);

    int updateByPrimaryKey(ExamInquiry record);
}