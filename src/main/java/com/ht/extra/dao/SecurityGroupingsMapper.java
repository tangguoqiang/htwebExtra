package com.ht.extra.dao;

import com.ht.extra.pojo.comm.SecurityGroupingsKey;

public interface SecurityGroupingsMapper {
    int deleteByPrimaryKey(SecurityGroupingsKey key);

    int insert(SecurityGroupingsKey record);

    int insertSelective(SecurityGroupingsKey record);
}