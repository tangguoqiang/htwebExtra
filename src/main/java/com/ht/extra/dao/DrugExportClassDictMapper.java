package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugExportClassDict;

public interface DrugExportClassDictMapper {
    int deleteByPrimaryKey(String exportClass);

    int insert(DrugExportClassDict record);

    int insertSelective(DrugExportClassDict record);

    DrugExportClassDict selectByPrimaryKey(String exportClass);

    int updateByPrimaryKeySelective(DrugExportClassDict record);

    int updateByPrimaryKey(DrugExportClassDict record);
}