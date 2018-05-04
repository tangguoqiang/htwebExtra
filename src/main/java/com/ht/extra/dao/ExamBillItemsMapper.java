package com.ht.extra.dao;

import com.ht.extra.pojo.exam.ExamBillItems;
import com.ht.extra.pojo.exam.ExamBillItemsKey;

public interface ExamBillItemsMapper {
    int deleteByPrimaryKey(ExamBillItemsKey key);

    int insert(ExamBillItems record);

    int insertSelective(ExamBillItems record);

    ExamBillItems selectByPrimaryKey(ExamBillItemsKey key);

    int updateByPrimaryKeySelective(ExamBillItems record);

    int updateByPrimaryKey(ExamBillItems record);
}