package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptsrVsDept;

public interface DeptsrVsDeptMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(DeptsrVsDept record);

    int insertSelective(DeptsrVsDept record);

    DeptsrVsDept selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(DeptsrVsDept record);

    int updateByPrimaryKey(DeptsrVsDept record);
}