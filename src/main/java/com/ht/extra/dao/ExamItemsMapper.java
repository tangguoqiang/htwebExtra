package com.ht.extra.dao;

import com.ht.extra.pojo.exam.ExamItems;
import com.ht.extra.pojo.exam.ExamItemsKey;

public interface ExamItemsMapper {
    int deleteByPrimaryKey(ExamItemsKey key);

    int insert(ExamItems record);

    int insertSelective(ExamItems record);

    ExamItems selectByPrimaryKey(ExamItemsKey key);

    int updateByPrimaryKeySelective(ExamItems record);

    int updateByPrimaryKey(ExamItems record);
}