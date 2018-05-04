package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PerformDeptKey;

public interface PerformDeptMapper {
    int deleteByPrimaryKey(PerformDeptKey key);

    int insert(PerformDeptKey record);

    int insertSelective(PerformDeptKey record);
}