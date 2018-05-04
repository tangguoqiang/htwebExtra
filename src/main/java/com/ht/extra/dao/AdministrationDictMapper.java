package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AdministrationDict;

public interface AdministrationDictMapper {
    int deleteByPrimaryKey(String administrationName);

    int insert(AdministrationDict record);

    int insertSelective(AdministrationDict record);

    AdministrationDict selectByPrimaryKey(String administrationName);

    int updateByPrimaryKeySelective(AdministrationDict record);

    int updateByPrimaryKey(AdministrationDict record);
}