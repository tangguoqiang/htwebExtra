package com.ht.extra.dao;

import com.ht.extra.pojo.exam.ExamMasterItems;

public interface ExamMasterItemsMapper {
    int deleteByPrimaryKey(Long serialNo);

    int insert(ExamMasterItems record);

    int insertSelective(ExamMasterItems record);

    ExamMasterItems selectByPrimaryKey(Long serialNo);

    int updateByPrimaryKeySelective(ExamMasterItems record);

    int updateByPrimaryKey(ExamMasterItems record);
}