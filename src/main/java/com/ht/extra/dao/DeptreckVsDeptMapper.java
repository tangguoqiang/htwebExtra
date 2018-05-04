package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptreckVsDept;

public interface DeptreckVsDeptMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(DeptreckVsDept record);

    int insertSelective(DeptreckVsDept record);

    DeptreckVsDept selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(DeptreckVsDept record);

    int updateByPrimaryKey(DeptreckVsDept record);
}