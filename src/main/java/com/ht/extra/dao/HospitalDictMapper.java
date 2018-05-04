package com.ht.extra.dao;

import com.ht.extra.pojo.comm.HospitalDict;

public interface HospitalDictMapper {
    int deleteByPrimaryKey(String hospitalCode);

    int insert(HospitalDict record);

    int insertSelective(HospitalDict record);

    HospitalDict selectByPrimaryKey(String hospitalCode);

    int updateByPrimaryKeySelective(HospitalDict record);

    int updateByPrimaryKey(HospitalDict record);
}