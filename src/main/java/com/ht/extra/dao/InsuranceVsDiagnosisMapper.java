package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuranceVsDiagnosis;
import com.ht.extra.pojo.insurance.InsuranceVsDiagnosisKey;

import java.util.List;

public interface InsuranceVsDiagnosisMapper {
    int deleteByPrimaryKey(InsuranceVsDiagnosisKey key);

    int insert(InsuranceVsDiagnosis record);

    int insertSelective(InsuranceVsDiagnosis record);

    InsuranceVsDiagnosis selectByPrimaryKey(InsuranceVsDiagnosisKey key);

    int updateByPrimaryKeySelective(InsuranceVsDiagnosis record);

    int updateByPrimaryKey(InsuranceVsDiagnosis record);

    List<InsuranceVsDiagnosis> selectByDiagnosisCode(String diagCode);
}