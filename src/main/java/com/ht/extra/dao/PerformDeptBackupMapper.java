package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PerformDeptBackupKey;

public interface PerformDeptBackupMapper {
    int deleteByPrimaryKey(PerformDeptBackupKey key);

    int insert(PerformDeptBackupKey record);

    int insertSelective(PerformDeptBackupKey record);
}