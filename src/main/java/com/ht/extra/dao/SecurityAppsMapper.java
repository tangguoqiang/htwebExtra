package com.ht.extra.dao;

import com.ht.extra.pojo.comm.SecurityApps;

public interface SecurityAppsMapper {
    int deleteByPrimaryKey(String application);

    int insert(SecurityApps record);

    int insertSelective(SecurityApps record);

    SecurityApps selectByPrimaryKey(String application);

    int updateByPrimaryKeySelective(SecurityApps record);

    int updateByPrimaryKey(SecurityApps record);
}