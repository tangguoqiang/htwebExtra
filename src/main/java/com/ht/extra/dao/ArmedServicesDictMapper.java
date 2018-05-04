package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ArmedServicesDict;

public interface ArmedServicesDictMapper {
    int deleteByPrimaryKey(String armedServicesName);

    int insert(ArmedServicesDict record);

    int insertSelective(ArmedServicesDict record);

    ArmedServicesDict selectByPrimaryKey(String armedServicesName);

    int updateByPrimaryKeySelective(ArmedServicesDict record);

    int updateByPrimaryKey(ArmedServicesDict record);
}