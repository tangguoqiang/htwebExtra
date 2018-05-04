package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.ClinicDiagnosis;

public interface ClinicDiagnosisMapper {
    int insert(ClinicDiagnosis record);

    int insertSelective(ClinicDiagnosis record);
}