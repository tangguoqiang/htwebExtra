package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PatientStatusChgDict;

public interface PatientStatusChgDictMapper {
    int deleteByPrimaryKey(String patientStatusChgCode);

    int insert(PatientStatusChgDict record);

    int insertSelective(PatientStatusChgDict record);

    PatientStatusChgDict selectByPrimaryKey(String patientStatusChgCode);

    int updateByPrimaryKeySelective(PatientStatusChgDict record);

    int updateByPrimaryKey(PatientStatusChgDict record);
}