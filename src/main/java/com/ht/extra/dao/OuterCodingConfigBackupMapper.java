package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OuterCodingConfigBackup;
import com.ht.extra.pojo.comm.OuterCodingConfigBackupKey;

public interface OuterCodingConfigBackupMapper {
    int deleteByPrimaryKey(OuterCodingConfigBackupKey key);

    int insert(OuterCodingConfigBackup record);

    int insertSelective(OuterCodingConfigBackup record);

    OuterCodingConfigBackup selectByPrimaryKey(OuterCodingConfigBackupKey key);

    int updateByPrimaryKeySelective(OuterCodingConfigBackup record);

    int updateByPrimaryKey(OuterCodingConfigBackup record);
}