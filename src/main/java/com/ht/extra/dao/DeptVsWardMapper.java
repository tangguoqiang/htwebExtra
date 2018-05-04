package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptVsWard;

public interface DeptVsWardMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(DeptVsWard record);

    int insertSelective(DeptVsWard record);

    DeptVsWard selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(DeptVsWard record);

    int updateByPrimaryKey(DeptVsWard record);
}