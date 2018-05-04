package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.InpPatientCheckLog;
import com.ht.extra.pojo.medrec.InpPatientCheckLogKey;

public interface InpPatientCheckLogMapper {
    int deleteByPrimaryKey(InpPatientCheckLogKey key);

    int insert(InpPatientCheckLog record);

    int insertSelective(InpPatientCheckLog record);

    InpPatientCheckLog selectByPrimaryKey(InpPatientCheckLogKey key);

    int updateByPrimaryKeySelective(InpPatientCheckLog record);

    int updateByPrimaryKey(InpPatientCheckLog record);
}