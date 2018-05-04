package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AppGrantDict;
import com.ht.extra.pojo.comm.AppGrantDictKey;

public interface AppGrantDictMapper {
    int deleteByPrimaryKey(AppGrantDictKey key);

    int insert(AppGrantDict record);

    int insertSelective(AppGrantDict record);

    AppGrantDict selectByPrimaryKey(AppGrantDictKey key);

    int updateByPrimaryKeySelective(AppGrantDict record);

    int updateByPrimaryKey(AppGrantDict record);
}