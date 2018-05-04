package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DutyDict;

public interface DutyDictMapper {
    int deleteByPrimaryKey(String dutyName);

    int insert(DutyDict record);

    int insertSelective(DutyDict record);

    DutyDict selectByPrimaryKey(String dutyName);

    int updateByPrimaryKeySelective(DutyDict record);

    int updateByPrimaryKey(DutyDict record);
}