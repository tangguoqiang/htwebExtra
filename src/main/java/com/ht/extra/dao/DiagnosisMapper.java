package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.Diagnosis;
import com.ht.extra.pojo.medrec.DiagnosisKey;

import java.util.List;

public interface DiagnosisMapper {
    int deleteByPrimaryKey(DiagnosisKey key);

    int insert(Diagnosis record);

    int insertSelective(Diagnosis record);

    Diagnosis selectByPrimaryKey(DiagnosisKey key);

    int updateByPrimaryKeySelective(Diagnosis record);

    int updateByPrimaryKey(Diagnosis record);

    Diagnosis selectBykeyDiag(String patientId, short visitId);

    List<Diagnosis> selectByPatientId(DiagnosisKey key);

    List<Diagnosis> selectByPatientIdAll(DiagnosisKey key);
}