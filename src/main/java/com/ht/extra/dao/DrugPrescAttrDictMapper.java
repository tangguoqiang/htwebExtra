package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugPrescAttrDict;

public interface DrugPrescAttrDictMapper {
    int deleteByPrimaryKey(String prescAttrName);

    int insert(DrugPrescAttrDict record);

    int insertSelective(DrugPrescAttrDict record);

    DrugPrescAttrDict selectByPrimaryKey(String prescAttrName);

    int updateByPrimaryKeySelective(DrugPrescAttrDict record);

    int updateByPrimaryKey(DrugPrescAttrDict record);
}