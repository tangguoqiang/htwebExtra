package com.ht.extra.dao;

import com.ht.extra.pojo.comm.UsersBackup;
import java.math.BigDecimal;

public interface UsersBackupMapper {
    int deleteByPrimaryKey(BigDecimal serialNo);

    int insert(UsersBackup record);

    int insertSelective(UsersBackup record);

    UsersBackup selectByPrimaryKey(BigDecimal serialNo);

    int updateByPrimaryKeySelective(UsersBackup record);

    int updateByPrimaryKey(UsersBackup record);
}