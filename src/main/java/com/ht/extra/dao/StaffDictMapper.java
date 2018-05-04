package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StaffDict;

import java.util.List;

public interface StaffDictMapper {
    int deleteByPrimaryKey(String empNo);

    int insert(StaffDict record);

    int insertSelective(StaffDict record);

    StaffDict selectByPrimaryKey(String empNo);

    int updateByPrimaryKeySelective(StaffDict record);

    int updateByPrimaryKey(StaffDict record);

    List<StaffDict> selectAll(String job);
}