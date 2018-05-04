package com.ht.extra.dao;

import com.ht.extra.pojo.comm.SpecimanDict;

public interface SpecimanDictMapper {
    int deleteByPrimaryKey(String specimanCode);

    int insert(SpecimanDict record);

    int insertSelective(SpecimanDict record);

    SpecimanDict selectByPrimaryKey(String specimanCode);

    int updateByPrimaryKeySelective(SpecimanDict record);

    int updateByPrimaryKey(SpecimanDict record);
}