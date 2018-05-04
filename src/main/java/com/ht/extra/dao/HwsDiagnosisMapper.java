package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.HwsDiagnosis;

public interface HwsDiagnosisMapper {
    int insert(HwsDiagnosis record);

    int insertSelective(HwsDiagnosis record);
}