package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ClinicItemDictBackup;
import com.ht.extra.pojo.comm.ClinicItemDictBackupKey;

public interface ClinicItemDictBackupMapper {
    int deleteByPrimaryKey(ClinicItemDictBackupKey key);

    int insert(ClinicItemDictBackup record);

    int insertSelective(ClinicItemDictBackup record);

    ClinicItemDictBackup selectByPrimaryKey(ClinicItemDictBackupKey key);

    int updateByPrimaryKeySelective(ClinicItemDictBackup record);

    int updateByPrimaryKey(ClinicItemDictBackup record);
}