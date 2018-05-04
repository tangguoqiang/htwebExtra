package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PatientSourceDict;

public interface PatientSourceDictMapper {
    int deleteByPrimaryKey(String patientSourceCode);

    int insert(PatientSourceDict record);

    int insertSelective(PatientSourceDict record);

    PatientSourceDict selectByPrimaryKey(String patientSourceCode);

    int updateByPrimaryKeySelective(PatientSourceDict record);

    int updateByPrimaryKey(PatientSourceDict record);
}