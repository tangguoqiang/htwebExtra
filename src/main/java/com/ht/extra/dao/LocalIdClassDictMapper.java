package com.ht.extra.dao;

import com.ht.extra.pojo.comm.LocalIdClassDict;

public interface LocalIdClassDictMapper {
    int deleteByPrimaryKey(String localIdClassCode);

    int insert(LocalIdClassDict record);

    int insertSelective(LocalIdClassDict record);

    LocalIdClassDict selectByPrimaryKey(String localIdClassCode);

    int updateByPrimaryKeySelective(LocalIdClassDict record);

    int updateByPrimaryKey(LocalIdClassDict record);
}