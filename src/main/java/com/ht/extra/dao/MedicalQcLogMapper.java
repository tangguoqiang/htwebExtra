package com.ht.extra.dao;

import com.ht.extra.pojo.inpadm.MedicalQcLog;
import com.ht.extra.pojo.inpadm.MedicalQcLogKey;

public interface MedicalQcLogMapper {
    int deleteByPrimaryKey(MedicalQcLogKey key);

    int insert(MedicalQcLog record);

    int insertSelective(MedicalQcLog record);

    MedicalQcLog selectByPrimaryKey(MedicalQcLogKey key);

    int updateByPrimaryKeySelective(MedicalQcLog record);

    int updateByPrimaryKey(MedicalQcLog record);
}