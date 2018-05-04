package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MedicalCosts;
import com.ht.extra.pojo.medrec.MedicalCostsKey;

import java.util.List;

public interface MedicalCostsMapper {
    int deleteByPrimaryKey(MedicalCostsKey key);

    int insert(MedicalCosts record);

    int insertSelective(MedicalCosts record);

    MedicalCosts selectByPrimaryKey(MedicalCostsKey key);

    int updateByPrimaryKeySelective(MedicalCosts record);

    int updateByPrimaryKey(MedicalCosts record);

    List<MedicalCosts> selectByMedical(MedicalCostsKey key);
}