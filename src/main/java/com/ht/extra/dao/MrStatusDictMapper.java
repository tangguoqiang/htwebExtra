package com.ht.extra.dao;

import com.ht.extra.pojo.comm.MrStatusDict;

public interface MrStatusDictMapper {
    int deleteByPrimaryKey(String mrStatusCode);

    int insert(MrStatusDict record);

    int insertSelective(MrStatusDict record);

    MrStatusDict selectByPrimaryKey(String mrStatusCode);

    int updateByPrimaryKeySelective(MrStatusDict record);

    int updateByPrimaryKey(MrStatusDict record);
}