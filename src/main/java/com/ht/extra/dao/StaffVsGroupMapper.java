package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StaffVsGroupKey;

public interface StaffVsGroupMapper {
    int deleteByPrimaryKey(StaffVsGroupKey key);

    int insert(StaffVsGroupKey record);

    int insertSelective(StaffVsGroupKey record);
}