package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MedicalPayWayDict;

public interface MedicalPayWayDictMapper {
    int deleteByPrimaryKey(String payWayName);

    int insert(MedicalPayWayDict record);

    int insertSelective(MedicalPayWayDict record);

    MedicalPayWayDict selectByPrimaryKey(String payWayName);

    int updateByPrimaryKeySelective(MedicalPayWayDict record);

    int updateByPrimaryKey(MedicalPayWayDict record);
}