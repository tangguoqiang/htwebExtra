package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StaffDict81;

public interface StaffDict81Mapper {
    int deleteByPrimaryKey(String nameId);

    int insert(StaffDict81 record);

    int insertSelective(StaffDict81 record);

    StaffDict81 selectByPrimaryKey(String nameId);

    int updateByPrimaryKeySelective(StaffDict81 record);

    int updateByPrimaryKey(StaffDict81 record);
}