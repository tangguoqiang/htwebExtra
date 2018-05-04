package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PhamDict;

public interface PhamDictMapper {
    int deleteByPrimaryKey(String phamStdCode);

    int insert(PhamDict record);

    int insertSelective(PhamDict record);

    PhamDict selectByPrimaryKey(String phamStdCode);

    int updateByPrimaryKeySelective(PhamDict record);

    int updateByPrimaryKey(PhamDict record);
}