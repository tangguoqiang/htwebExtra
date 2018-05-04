package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugDict;
import com.ht.extra.pojo.comm.DrugDictKey;

public interface DrugDictMapper {
    int deleteByPrimaryKey(DrugDictKey key);

    int insert(DrugDict record);

    int insertSelective(DrugDict record);

    DrugDict selectByPrimaryKey(DrugDictKey key);

    int updateByPrimaryKeySelective(DrugDict record);

    int updateByPrimaryKey(DrugDict record);
}