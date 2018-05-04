package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ClinicVsChargeBackup;
import com.ht.extra.pojo.comm.ClinicVsChargeBackupKey;

public interface ClinicVsChargeBackupMapper {
    int deleteByPrimaryKey(ClinicVsChargeBackupKey key);

    int insert(ClinicVsChargeBackup record);

    int insertSelective(ClinicVsChargeBackup record);

    ClinicVsChargeBackup selectByPrimaryKey(ClinicVsChargeBackupKey key);

    int updateByPrimaryKeySelective(ClinicVsChargeBackup record);

    int updateByPrimaryKey(ClinicVsChargeBackup record);
}