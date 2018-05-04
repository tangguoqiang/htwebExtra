package com.ht.extra.dao;

import com.ht.extra.pojo.comm.MrClassDict;

public interface MrClassDictMapper {
    int deleteByPrimaryKey(String mrClassCode);

    int insert(MrClassDict record);

    int insertSelective(MrClassDict record);

    MrClassDict selectByPrimaryKey(String mrClassCode);

    int updateByPrimaryKeySelective(MrClassDict record);

    int updateByPrimaryKey(MrClassDict record);
}