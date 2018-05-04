package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DietProviderDict;

public interface DietProviderDictMapper {
    int deleteByPrimaryKey(String sectionCode);

    int insert(DietProviderDict record);

    int insertSelective(DietProviderDict record);

    DietProviderDict selectByPrimaryKey(String sectionCode);

    int updateByPrimaryKeySelective(DietProviderDict record);

    int updateByPrimaryKey(DietProviderDict record);
}