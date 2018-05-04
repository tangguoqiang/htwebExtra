package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StaffAdmin81;

public interface StaffAdmin81Mapper {
    int deleteByPrimaryKey(String adminCode);

    int insert(StaffAdmin81 record);

    int insertSelective(StaffAdmin81 record);

    StaffAdmin81 selectByPrimaryKey(String adminCode);

    int updateByPrimaryKeySelective(StaffAdmin81 record);

    int updateByPrimaryKey(StaffAdmin81 record);
}