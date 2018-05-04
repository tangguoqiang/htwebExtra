package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StaffJob81;

public interface StaffJob81Mapper {
    int deleteByPrimaryKey(String jobCode);

    int insert(StaffJob81 record);

    int insertSelective(StaffJob81 record);

    StaffJob81 selectByPrimaryKey(String jobCode);

    int updateByPrimaryKeySelective(StaffJob81 record);

    int updateByPrimaryKey(StaffJob81 record);
}