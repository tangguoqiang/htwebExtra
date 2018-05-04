package com.ht.extra.dao;

import com.ht.extra.pojo.comm.UsersTemp;

public interface UsersTempMapper {
    int deleteByPrimaryKey(String dbUser);

    int insert(UsersTemp record);

    int insertSelective(UsersTemp record);

    UsersTemp selectByPrimaryKey(String dbUser);

    int updateByPrimaryKeySelective(UsersTemp record);

    int updateByPrimaryKey(UsersTemp record);
}