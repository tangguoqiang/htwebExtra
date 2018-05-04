package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ClinicItemNameDictBackup;
import com.ht.extra.pojo.comm.ClinicItemNameDictBackupKey;

public interface ClinicItemNameDictBackupMapper {
    int deleteByPrimaryKey(ClinicItemNameDictBackupKey key);

    int insert(ClinicItemNameDictBackup record);

    int insertSelective(ClinicItemNameDictBackup record);

    ClinicItemNameDictBackup selectByPrimaryKey(ClinicItemNameDictBackupKey key);

    int updateByPrimaryKeySelective(ClinicItemNameDictBackup record);

    int updateByPrimaryKey(ClinicItemNameDictBackup record);
}