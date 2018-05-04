package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DiagnosisTypeDict;

public interface DiagnosisTypeDictMapper {
    int deleteByPrimaryKey(String diagnosisTypeCode);

    int insert(DiagnosisTypeDict record);

    int insertSelective(DiagnosisTypeDict record);

    DiagnosisTypeDict selectByPrimaryKey(String diagnosisTypeCode);

    int updateByPrimaryKeySelective(DiagnosisTypeDict record);

    int updateByPrimaryKey(DiagnosisTypeDict record);
}