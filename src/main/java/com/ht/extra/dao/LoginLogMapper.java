package com.ht.extra.dao;

import com.ht.extra.pojo.comm.LoginLog;
import com.ht.extra.pojo.comm.LoginLogKey;

public interface LoginLogMapper {
    int deleteByPrimaryKey(LoginLogKey key);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(LoginLogKey key);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
}