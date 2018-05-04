package com.ht.extra.dao;

import com.ht.extra.pojo.comm.BedClassDictBackup;

public interface BedClassDictBackupMapper {
    int deleteByPrimaryKey(String bedClassCode);

    int insert(BedClassDictBackup record);

    int insertSelective(BedClassDictBackup record);

    BedClassDictBackup selectByPrimaryKey(String bedClassCode);

    int updateByPrimaryKeySelective(BedClassDictBackup record);

    int updateByPrimaryKey(BedClassDictBackup record);
}