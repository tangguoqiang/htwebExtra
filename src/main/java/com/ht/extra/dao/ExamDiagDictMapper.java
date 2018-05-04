package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ExamDiagDict;
import com.ht.extra.pojo.comm.ExamDiagDictKey;

public interface ExamDiagDictMapper {
    int deleteByPrimaryKey(ExamDiagDictKey key);

    int insert(ExamDiagDict record);

    int insertSelective(ExamDiagDict record);

    ExamDiagDict selectByPrimaryKey(ExamDiagDictKey key);

    int updateByPrimaryKeySelective(ExamDiagDict record);

    int updateByPrimaryKey(ExamDiagDict record);
}