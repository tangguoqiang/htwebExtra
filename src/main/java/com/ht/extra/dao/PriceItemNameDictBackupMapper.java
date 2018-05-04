package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PriceItemNameDictBackup;
import com.ht.extra.pojo.comm.PriceItemNameDictBackupKey;

public interface PriceItemNameDictBackupMapper {
    int deleteByPrimaryKey(PriceItemNameDictBackupKey key);

    int insert(PriceItemNameDictBackup record);

    int insertSelective(PriceItemNameDictBackup record);

    PriceItemNameDictBackup selectByPrimaryKey(PriceItemNameDictBackupKey key);

    int updateByPrimaryKeySelective(PriceItemNameDictBackup record);

    int updateByPrimaryKey(PriceItemNameDictBackup record);
}