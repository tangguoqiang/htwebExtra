package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DoctorTitleDict;

public interface DoctorTitleDictMapper {
    int deleteByPrimaryKey(String titleName);

    int insert(DoctorTitleDict record);

    int insertSelective(DoctorTitleDict record);

    DoctorTitleDict selectByPrimaryKey(String titleName);

    int updateByPrimaryKeySelective(DoctorTitleDict record);

    int updateByPrimaryKey(DoctorTitleDict record);
}