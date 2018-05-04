package com.ht.extra.dao;

import com.ht.extra.pojo.comm.NationDict;

public interface NationDictMapper {
    int deleteByPrimaryKey(String nationName);

    int insert(NationDict record);

    int insertSelective(NationDict record);

    NationDict selectByPrimaryKey(String nationName);

    int updateByPrimaryKeySelective(NationDict record);

    int updateByPrimaryKey(NationDict record);
}