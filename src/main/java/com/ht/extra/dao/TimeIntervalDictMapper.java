package com.ht.extra.dao;

import com.ht.extra.pojo.comm.TimeIntervalDict;

public interface TimeIntervalDictMapper {
    int deleteByPrimaryKey(String timeIntervalName);

    int insert(TimeIntervalDict record);

    int insertSelective(TimeIntervalDict record);

    TimeIntervalDict selectByPrimaryKey(String timeIntervalName);

    int updateByPrimaryKeySelective(TimeIntervalDict record);

    int updateByPrimaryKey(TimeIntervalDict record);
}