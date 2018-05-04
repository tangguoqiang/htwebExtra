package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DiagnosisCodeCompare;
import com.ht.extra.pojo.comm.DiagnosisCodeCompareKey;

public interface DiagnosisCodeCompareMapper {
    int deleteByPrimaryKey(DiagnosisCodeCompareKey key);

    int insert(DiagnosisCodeCompare record);

    int insertSelective(DiagnosisCodeCompare record);

    DiagnosisCodeCompare selectByPrimaryKey(DiagnosisCodeCompareKey key);

    int updateByPrimaryKeySelective(DiagnosisCodeCompare record);

    int updateByPrimaryKey(DiagnosisCodeCompare record);
}