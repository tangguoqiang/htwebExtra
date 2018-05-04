package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AdmissionCauseDict;

public interface AdmissionCauseDictMapper {
    int deleteByPrimaryKey(String admissionCauseName);

    int insert(AdmissionCauseDict record);

    int insertSelective(AdmissionCauseDict record);

    AdmissionCauseDict selectByPrimaryKey(String admissionCauseName);

    int updateByPrimaryKeySelective(AdmissionCauseDict record);

    int updateByPrimaryKey(AdmissionCauseDict record);
}