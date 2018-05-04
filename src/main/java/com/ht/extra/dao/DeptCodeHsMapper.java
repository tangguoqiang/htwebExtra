package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptCodeHs;

public interface DeptCodeHsMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(DeptCodeHs record);

    int insertSelective(DeptCodeHs record);

    DeptCodeHs selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(DeptCodeHs record);

    int updateByPrimaryKey(DeptCodeHs record);
}