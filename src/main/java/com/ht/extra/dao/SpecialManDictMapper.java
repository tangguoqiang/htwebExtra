package com.ht.extra.dao;

import com.ht.extra.pojo.comm.SpecialManDict;

public interface SpecialManDictMapper {
    int deleteByPrimaryKey(String manName);

    int insert(SpecialManDict record);

    int insertSelective(SpecialManDict record);

    SpecialManDict selectByPrimaryKey(String manName);

    int updateByPrimaryKeySelective(SpecialManDict record);

    int updateByPrimaryKey(SpecialManDict record);
}