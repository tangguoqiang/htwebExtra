package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PatientClassDict;

public interface PatientClassDictMapper {
    int deleteByPrimaryKey(String patientClassCode);

    int insert(PatientClassDict record);

    int insertSelective(PatientClassDict record);

    PatientClassDict selectByPrimaryKey(String patientClassCode);

    int updateByPrimaryKeySelective(PatientClassDict record);

    int updateByPrimaryKey(PatientClassDict record);
}