package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuranceDiagnosis;
import com.ht.extra.pojo.insurance.InsuranceDiagnosisKey;

public interface InsuranceDiagnosisMapper {
    int deleteByPrimaryKey(InsuranceDiagnosisKey key);

    int insert(InsuranceDiagnosis record);

    int insertSelective(InsuranceDiagnosis record);

    InsuranceDiagnosis selectByPrimaryKey(InsuranceDiagnosisKey key);

    int updateByPrimaryKeySelective(InsuranceDiagnosis record);

    int updateByPrimaryKey(InsuranceDiagnosis record);
}