package com.ht.extra.dao;

import com.ht.extra.pojo.comm.MaritalStatusDict;

public interface MaritalStatusDictMapper {
    int deleteByPrimaryKey(String maritalStatusName);

    int insert(MaritalStatusDict record);

    int insertSelective(MaritalStatusDict record);

    MaritalStatusDict selectByPrimaryKey(String maritalStatusName);

    int updateByPrimaryKeySelective(MaritalStatusDict record);

    int updateByPrimaryKey(MaritalStatusDict record);
}