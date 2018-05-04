package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugNameDict;
import com.ht.extra.pojo.comm.DrugNameDictKey;

public interface DrugNameDictMapper {
    int deleteByPrimaryKey(DrugNameDictKey key);

    int insert(DrugNameDict record);

    int insertSelective(DrugNameDict record);

    DrugNameDict selectByPrimaryKey(DrugNameDictKey key);

    int updateByPrimaryKeySelective(DrugNameDict record);

    int updateByPrimaryKey(DrugNameDict record);
}