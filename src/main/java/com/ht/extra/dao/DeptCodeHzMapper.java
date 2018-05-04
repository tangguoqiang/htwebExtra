package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptCodeHz;

public interface DeptCodeHzMapper {
    int deleteByPrimaryKey(String deptCodehz);

    int insert(DeptCodeHz record);

    int insertSelective(DeptCodeHz record);

    DeptCodeHz selectByPrimaryKey(String deptCodehz);

    int updateByPrimaryKeySelective(DeptCodeHz record);

    int updateByPrimaryKey(DeptCodeHz record);
}