package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugClassDict;

public interface DrugClassDictMapper {
    int deleteByPrimaryKey(String classCode);

    int insert(DrugClassDict record);

    int insertSelective(DrugClassDict record);

    DrugClassDict selectByPrimaryKey(String classCode);

    int updateByPrimaryKeySelective(DrugClassDict record);

    int updateByPrimaryKey(DrugClassDict record);
}