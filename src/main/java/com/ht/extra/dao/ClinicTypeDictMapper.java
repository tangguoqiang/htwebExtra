package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.ClinicTypeDict;

public interface ClinicTypeDictMapper {
    int deleteByPrimaryKey(String clinicType);

    int insert(ClinicTypeDict record);

    int insertSelective(ClinicTypeDict record);

    ClinicTypeDict selectByPrimaryKey(String clinicType);

    int updateByPrimaryKeySelective(ClinicTypeDict record);

    int updateByPrimaryKey(ClinicTypeDict record);
}