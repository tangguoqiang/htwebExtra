package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ApplicationGrantLog;
import com.ht.extra.pojo.comm.ApplicationGrantLogKey;

public interface ApplicationGrantLogMapper {
    int deleteByPrimaryKey(ApplicationGrantLogKey key);

    int insert(ApplicationGrantLog record);

    int insertSelective(ApplicationGrantLog record);

    ApplicationGrantLog selectByPrimaryKey(ApplicationGrantLogKey key);

    int updateByPrimaryKeySelective(ApplicationGrantLog record);

    int updateByPrimaryKey(ApplicationGrantLog record);
}