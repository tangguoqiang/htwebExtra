package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ExamTmp;

public interface ExamTmpMapper {
    int deleteByPrimaryKey(String examNo);

    int insert(ExamTmp record);

    int insertSelective(ExamTmp record);
}