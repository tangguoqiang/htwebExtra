package com.ht.extra.dao;

import com.ht.extra.pojo.comm.LocalQq;

public interface LocalQqMapper {
    int deleteByPrimaryKey(String hostName);

    int insert(LocalQq record);

    int insertSelective(LocalQq record);

    LocalQq selectByPrimaryKey(String hostName);

    int updateByPrimaryKeySelective(LocalQq record);

    int updateByPrimaryKey(LocalQq record);
}