package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptHouse;

public interface DeptHouseMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(DeptHouse record);

    int insertSelective(DeptHouse record);

    DeptHouse selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(DeptHouse record);

    int updateByPrimaryKeyWithBLOBs(DeptHouse record);

    int updateByPrimaryKey(DeptHouse record);
}