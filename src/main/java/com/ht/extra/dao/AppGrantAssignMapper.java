package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AppGrantAssign;
import com.ht.extra.pojo.comm.AppGrantAssignKey;

public interface AppGrantAssignMapper {
    int deleteByPrimaryKey(AppGrantAssignKey key);

    int insert(AppGrantAssign record);

    int insertSelective(AppGrantAssign record);

    AppGrantAssign selectByPrimaryKey(AppGrantAssignKey key);

    int updateByPrimaryKeySelective(AppGrantAssign record);

    int updateByPrimaryKey(AppGrantAssign record);
}