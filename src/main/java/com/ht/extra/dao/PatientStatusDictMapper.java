package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PatientStatusDict;

public interface PatientStatusDictMapper {
    int deleteByPrimaryKey(String patientStatusCode);

    int insert(PatientStatusDict record);

    int insertSelective(PatientStatusDict record);

    PatientStatusDict selectByPrimaryKey(String patientStatusCode);

    int updateByPrimaryKeySelective(PatientStatusDict record);

    int updateByPrimaryKey(PatientStatusDict record);
}