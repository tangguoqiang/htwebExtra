package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AppRolesKey;

public interface AppRolesMapper {
    int deleteByPrimaryKey(AppRolesKey key);

    int insert(AppRolesKey record);

    int insertSelective(AppRolesKey record);
}