package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ReckItemClassDict;

public interface ReckItemClassDictMapper {
    int deleteByPrimaryKey(String classCode);

    int insert(ReckItemClassDict record);

    int insertSelective(ReckItemClassDict record);

    ReckItemClassDict selectByPrimaryKey(String classCode);

    int updateByPrimaryKeySelective(ReckItemClassDict record);

    int updateByPrimaryKey(ReckItemClassDict record);
}