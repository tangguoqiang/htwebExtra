package com.ht.extra.dao;

import com.ht.extra.pojo.comm.HealDict;

public interface HealDictMapper {
    int deleteByPrimaryKey(String healName);

    int insert(HealDict record);

    int insertSelective(HealDict record);

    HealDict selectByPrimaryKey(String healName);

    int updateByPrimaryKeySelective(HealDict record);

    int updateByPrimaryKey(HealDict record);
}