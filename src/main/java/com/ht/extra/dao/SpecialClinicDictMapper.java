package com.ht.extra.dao;

import com.ht.extra.pojo.comm.SpecialClinicDict;

public interface SpecialClinicDictMapper {
    int deleteByPrimaryKey(String specialClinicName);

    int insert(SpecialClinicDict record);

    int insertSelective(SpecialClinicDict record);

    SpecialClinicDict selectByPrimaryKey(String specialClinicName);

    int updateByPrimaryKeySelective(SpecialClinicDict record);

    int updateByPrimaryKey(SpecialClinicDict record);
}