package com.ht.extra.dao;

import com.ht.extra.pojo.comm.LabItemClassDict;

public interface LabItemClassDictMapper {
    int deleteByPrimaryKey(String classCode);

    int insert(LabItemClassDict record);

    int insertSelective(LabItemClassDict record);

    LabItemClassDict selectByPrimaryKey(String classCode);

    int updateByPrimaryKeySelective(LabItemClassDict record);

    int updateByPrimaryKey(LabItemClassDict record);
}