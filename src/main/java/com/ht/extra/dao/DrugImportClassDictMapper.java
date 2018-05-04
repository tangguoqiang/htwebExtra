package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugImportClassDict;

public interface DrugImportClassDictMapper {
    int deleteByPrimaryKey(String importClass);

    int insert(DrugImportClassDict record);

    int insertSelective(DrugImportClassDict record);

    DrugImportClassDict selectByPrimaryKey(String importClass);

    int updateByPrimaryKeySelective(DrugImportClassDict record);

    int updateByPrimaryKey(DrugImportClassDict record);
}