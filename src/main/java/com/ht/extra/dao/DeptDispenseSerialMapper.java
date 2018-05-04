package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptDispenseSerial;

public interface DeptDispenseSerialMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(DeptDispenseSerial record);

    int insertSelective(DeptDispenseSerial record);

    DeptDispenseSerial selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(DeptDispenseSerial record);

    int updateByPrimaryKey(DeptDispenseSerial record);
}