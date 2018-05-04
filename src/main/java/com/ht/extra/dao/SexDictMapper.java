package com.ht.extra.dao;

import com.ht.extra.pojo.comm.SexDict;

public interface SexDictMapper {
    int deleteByPrimaryKey(String sexName);

    int insert(SexDict record);

    int insertSelective(SexDict record);

    SexDict selectByPrimaryKey(String sexName);

    int updateByPrimaryKeySelective(SexDict record);

    int updateByPrimaryKey(SexDict record);
}