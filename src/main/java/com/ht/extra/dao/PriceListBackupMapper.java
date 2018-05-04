package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PriceListBackup;

public interface PriceListBackupMapper {
    int insert(PriceListBackup record);

    int insertSelective(PriceListBackup record);
}