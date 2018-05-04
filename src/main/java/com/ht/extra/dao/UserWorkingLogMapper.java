package com.ht.extra.dao;

import com.ht.extra.pojo.comm.UserWorkingLog;
import com.ht.extra.pojo.comm.UserWorkingLogKey;

public interface UserWorkingLogMapper {
    int deleteByPrimaryKey(UserWorkingLogKey key);

    int insert(UserWorkingLog record);

    int insertSelective(UserWorkingLog record);

    UserWorkingLog selectByPrimaryKey(UserWorkingLogKey key);

    int updateByPrimaryKeySelective(UserWorkingLog record);

    int updateByPrimaryKey(UserWorkingLog record);
}