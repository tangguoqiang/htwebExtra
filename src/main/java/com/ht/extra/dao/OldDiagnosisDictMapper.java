package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OldDiagnosisDict;
import com.ht.extra.pojo.comm.OldDiagnosisDictKey;

public interface OldDiagnosisDictMapper {
    int deleteByPrimaryKey(OldDiagnosisDictKey key);

    int insert(OldDiagnosisDict record);

    int insertSelective(OldDiagnosisDict record);

    OldDiagnosisDict selectByPrimaryKey(OldDiagnosisDictKey key);

    int updateByPrimaryKeySelective(OldDiagnosisDict record);

    int updateByPrimaryKey(OldDiagnosisDict record);
}