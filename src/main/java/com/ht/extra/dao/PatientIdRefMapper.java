package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PatientIdRef;
import com.ht.extra.pojo.comm.PatientIdRefKey;

public interface PatientIdRefMapper {
    int deleteByPrimaryKey(PatientIdRefKey key);

    int insert(PatientIdRef record);

    int insertSelective(PatientIdRef record);

    PatientIdRef selectByPrimaryKey(PatientIdRefKey key);

    int updateByPrimaryKeySelective(PatientIdRef record);

    int updateByPrimaryKey(PatientIdRef record);
}