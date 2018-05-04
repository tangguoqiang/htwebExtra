package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MedicalCostsBack;
import com.ht.extra.pojo.medrec.MedicalCostsBackKey;

public interface MedicalCostsBackMapper {
    int deleteByPrimaryKey(MedicalCostsBackKey key);

    int insert(MedicalCostsBack record);

    int insertSelective(MedicalCostsBack record);

    MedicalCostsBack selectByPrimaryKey(MedicalCostsBackKey key);

    int updateByPrimaryKeySelective(MedicalCostsBack record);

    int updateByPrimaryKey(MedicalCostsBack record);
}