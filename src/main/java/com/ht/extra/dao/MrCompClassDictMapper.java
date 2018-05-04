package com.ht.extra.dao;

import com.ht.extra.pojo.comm.MrCompClassDict;

public interface MrCompClassDictMapper {
    int deleteByPrimaryKey(String compClass);

    int insert(MrCompClassDict record);

    int insertSelective(MrCompClassDict record);

    MrCompClassDict selectByPrimaryKey(String compClass);

    int updateByPrimaryKeySelective(MrCompClassDict record);

    int updateByPrimaryKey(MrCompClassDict record);
}