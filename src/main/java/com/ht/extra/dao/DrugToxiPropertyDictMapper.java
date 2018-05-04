package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugToxiPropertyDict;

public interface DrugToxiPropertyDictMapper {
    int deleteByPrimaryKey(String toxiName);

    int insert(DrugToxiPropertyDict record);

    int insertSelective(DrugToxiPropertyDict record);

    DrugToxiPropertyDict selectByPrimaryKey(String toxiName);

    int updateByPrimaryKeySelective(DrugToxiPropertyDict record);

    int updateByPrimaryKey(DrugToxiPropertyDict record);
}