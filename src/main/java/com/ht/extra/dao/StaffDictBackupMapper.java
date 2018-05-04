package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StaffDictBackup;

public interface StaffDictBackupMapper {
    int deleteByPrimaryKey(String empNo);

    int insert(StaffDictBackup record);

    int insertSelective(StaffDictBackup record);

    StaffDictBackup selectByPrimaryKey(String empNo);

    int updateByPrimaryKeySelective(StaffDictBackup record);

    int updateByPrimaryKey(StaffDictBackup record);
}