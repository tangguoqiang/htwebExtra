package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ApplicationConfig;
import com.ht.extra.pojo.comm.ApplicationConfigKey;

public interface ApplicationConfigMapper {
    int deleteByPrimaryKey(ApplicationConfigKey key);

    int insert(ApplicationConfig record);

    int insertSelective(ApplicationConfig record);

    ApplicationConfig selectByPrimaryKey(ApplicationConfigKey key);

    int updateByPrimaryKeySelective(ApplicationConfig record);

    int updateByPrimaryKey(ApplicationConfig record);
}