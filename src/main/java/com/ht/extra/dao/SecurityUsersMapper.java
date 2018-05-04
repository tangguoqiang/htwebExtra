package com.ht.extra.dao;

import com.ht.extra.pojo.comm.SecurityUsers;

public interface SecurityUsersMapper {
    int deleteByPrimaryKey(String name);

    int insert(SecurityUsers record);

    int insertSelective(SecurityUsers record);

    SecurityUsers selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(SecurityUsers record);

    int updateByPrimaryKey(SecurityUsers record);
}