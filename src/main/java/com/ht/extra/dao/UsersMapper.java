package com.ht.extra.dao;

import com.ht.extra.pojo.comm.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(String dbUser);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String dbUser);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users selectUserName(String userName);
}