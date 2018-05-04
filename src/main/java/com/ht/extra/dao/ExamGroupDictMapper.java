package com.ht.extra.dao;

import com.ht.extra.pojo.exam.ExamGroupDictKey;

public interface ExamGroupDictMapper {
    int deleteByPrimaryKey(ExamGroupDictKey key);

    int insert(ExamGroupDictKey record);

    int insertSelective(ExamGroupDictKey record);
}