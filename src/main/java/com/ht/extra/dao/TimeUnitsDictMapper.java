package com.ht.extra.dao;

import com.ht.extra.pojo.comm.TimeUnitsDict;

public interface TimeUnitsDictMapper {
    int deleteByPrimaryKey(String timeUnitsName);

    int insert(TimeUnitsDict record);

    int insertSelective(TimeUnitsDict record);

    TimeUnitsDict selectByPrimaryKey(String timeUnitsName);

    int updateByPrimaryKeySelective(TimeUnitsDict record);

    int updateByPrimaryKey(TimeUnitsDict record);
}