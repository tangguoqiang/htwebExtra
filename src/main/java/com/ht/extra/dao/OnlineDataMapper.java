package com.ht.extra.dao;

import com.ht.extra.pojo.lab.OnlineData;

public interface OnlineDataMapper {
    int deleteByPrimaryKey(Integer serialNo);

    int insert(OnlineData record);

    int insertSelective(OnlineData record);

    OnlineData selectByPrimaryKey(Integer serialNo);

    int updateByPrimaryKeySelective(OnlineData record);

    int updateByPrimaryKey(OnlineData record);
}