package com.ht.extra.dao;

import com.ht.extra.pojo.exam.ExamPatMi;
import com.ht.extra.pojo.exam.ExamPatMiKey;

public interface ExamPatMiMapper {
    int deleteByPrimaryKey(ExamPatMiKey key);

    int insert(ExamPatMi record);

    int insertSelective(ExamPatMi record);

    ExamPatMi selectByPrimaryKey(ExamPatMiKey key);

    int updateByPrimaryKeySelective(ExamPatMi record);

    int updateByPrimaryKey(ExamPatMi record);
}