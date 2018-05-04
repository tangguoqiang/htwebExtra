package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StandardVsPriceBackup;
import com.ht.extra.pojo.comm.StandardVsPriceBackupKey;

public interface StandardVsPriceBackupMapper {
    int deleteByPrimaryKey(StandardVsPriceBackupKey key);

    int insert(StandardVsPriceBackup record);

    int insertSelective(StandardVsPriceBackup record);

    StandardVsPriceBackup selectByPrimaryKey(StandardVsPriceBackupKey key);

    int updateByPrimaryKeySelective(StandardVsPriceBackup record);

    int updateByPrimaryKey(StandardVsPriceBackup record);
}