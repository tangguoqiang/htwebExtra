package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugDispPropertyDict;

public interface DrugDispPropertyDictMapper {
    int deleteByPrimaryKey(String dispensingProperty);

    int insert(DrugDispPropertyDict record);

    int insertSelective(DrugDispPropertyDict record);

    DrugDispPropertyDict selectByPrimaryKey(String dispensingProperty);

    int updateByPrimaryKeySelective(DrugDispPropertyDict record);

    int updateByPrimaryKey(DrugDispPropertyDict record);
}