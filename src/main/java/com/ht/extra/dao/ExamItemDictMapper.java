package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ExamItemDict;

public interface ExamItemDictMapper {
    int insert(ExamItemDict record);

    int insertSelective(ExamItemDict record);
}