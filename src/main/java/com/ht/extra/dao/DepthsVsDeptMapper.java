package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DepthsVsDept;

public interface DepthsVsDeptMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(DepthsVsDept record);

    int insertSelective(DepthsVsDept record);

    DepthsVsDept selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(DepthsVsDept record);

    int updateByPrimaryKey(DepthsVsDept record);
}