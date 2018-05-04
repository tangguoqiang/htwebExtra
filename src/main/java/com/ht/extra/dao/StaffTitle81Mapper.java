package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StaffTitle81;

public interface StaffTitle81Mapper {
    int deleteByPrimaryKey(String titleCode);

    int insert(StaffTitle81 record);

    int insertSelective(StaffTitle81 record);

    StaffTitle81 selectByPrimaryKey(String titleCode);

    int updateByPrimaryKeySelective(StaffTitle81 record);

    int updateByPrimaryKey(StaffTitle81 record);
}