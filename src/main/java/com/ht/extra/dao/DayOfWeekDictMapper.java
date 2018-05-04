package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DayOfWeekDict;

public interface DayOfWeekDictMapper {
    int deleteByPrimaryKey(Short dayNumber);

    int insert(DayOfWeekDict record);

    int insertSelective(DayOfWeekDict record);

    DayOfWeekDict selectByPrimaryKey(Short dayNumber);

    int updateByPrimaryKeySelective(DayOfWeekDict record);

    int updateByPrimaryKey(DayOfWeekDict record);
}