package com.ht.extra.dao;

import com.ht.extra.pojo.comm.BedClassDict;

public interface BedClassDictMapper {
    int deleteByPrimaryKey(String bedClassCode);

    int insert(BedClassDict record);

    int insertSelective(BedClassDict record);

    BedClassDict selectByPrimaryKey(String bedClassCode);

    int updateByPrimaryKeySelective(BedClassDict record);

    int updateByPrimaryKey(BedClassDict record);
}