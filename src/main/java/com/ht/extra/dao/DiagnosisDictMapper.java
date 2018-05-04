package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DiagnosisDict;
import com.ht.extra.pojo.comm.DiagnosisDictKey;

public interface DiagnosisDictMapper {
    int deleteByPrimaryKey(DiagnosisDictKey key);

    int insert(DiagnosisDict record);

    int insertSelective(DiagnosisDict record);

    DiagnosisDict selectByPrimaryKey(DiagnosisDictKey key);

    int updateByPrimaryKeySelective(DiagnosisDict record);

    int updateByPrimaryKey(DiagnosisDict record);
}