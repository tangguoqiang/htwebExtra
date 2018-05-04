package com.ht.extra.dao;

import com.ht.extra.pojo.pharmacy.DrugPrescDetailTemp;
import com.ht.extra.pojo.pharmacy.DrugPrescDetailTempKey;

public interface DrugPrescDetailTempMapper {
    int deleteByPrimaryKey(DrugPrescDetailTempKey key);

    int insert(DrugPrescDetailTemp record);

    int insertSelective(DrugPrescDetailTemp record);

    DrugPrescDetailTemp selectByPrimaryKey(DrugPrescDetailTempKey key);

    int updateByPrimaryKeySelective(DrugPrescDetailTemp record);

    int updateByPrimaryKey(DrugPrescDetailTemp record);
}