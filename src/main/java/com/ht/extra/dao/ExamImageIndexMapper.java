package com.ht.extra.dao;

import com.ht.extra.pojo.exam.ExamImageIndex;

public interface ExamImageIndexMapper {
    int deleteByPrimaryKey(String fileName);

    int insert(ExamImageIndex record);

    int insertSelective(ExamImageIndex record);

    ExamImageIndex selectByPrimaryKey(String fileName);

    int updateByPrimaryKeySelective(ExamImageIndex record);

    int updateByPrimaryKey(ExamImageIndex record);
}