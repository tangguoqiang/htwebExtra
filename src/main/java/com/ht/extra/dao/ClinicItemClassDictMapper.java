package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ClinicItemClassDict;

public interface ClinicItemClassDictMapper {
    int deleteByPrimaryKey(String classCode);

    int insert(ClinicItemClassDict record);

    int insertSelective(ClinicItemClassDict record);

    ClinicItemClassDict selectByPrimaryKey(String classCode);

    int updateByPrimaryKeySelective(ClinicItemClassDict record);

    int updateByPrimaryKey(ClinicItemClassDict record);
}