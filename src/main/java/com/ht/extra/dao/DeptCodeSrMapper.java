package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptCodeSr;

public interface DeptCodeSrMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(DeptCodeSr record);

    int insertSelective(DeptCodeSr record);

    DeptCodeSr selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(DeptCodeSr record);

    int updateByPrimaryKey(DeptCodeSr record);
}