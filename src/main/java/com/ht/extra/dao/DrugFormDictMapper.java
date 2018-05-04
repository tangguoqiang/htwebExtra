package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugFormDict;

public interface DrugFormDictMapper {
    int deleteByPrimaryKey(String formCode);

    int insert(DrugFormDict record);

    int insertSelective(DrugFormDict record);

    DrugFormDict selectByPrimaryKey(String formCode);

    int updateByPrimaryKeySelective(DrugFormDict record);

    int updateByPrimaryKey(DrugFormDict record);
}