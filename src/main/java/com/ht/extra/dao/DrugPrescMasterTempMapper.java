package com.ht.extra.dao;

import com.ht.extra.pojo.pharmacy.DrugPrescMasterTemp;
import com.ht.extra.pojo.pharmacy.DrugPrescMasterTempKey;

public interface DrugPrescMasterTempMapper {
    int deleteByPrimaryKey(DrugPrescMasterTempKey key);

    int insert(DrugPrescMasterTemp record);

    int insertSelective(DrugPrescMasterTemp record);

    DrugPrescMasterTemp selectByPrimaryKey(DrugPrescMasterTempKey key);

    int updateByPrimaryKeySelective(DrugPrescMasterTemp record);

    int updateByPrimaryKey(DrugPrescMasterTemp record);
}