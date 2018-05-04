package com.ht.extra.dao;

import com.ht.extra.pojo.comm.TitleDict;

public interface TitleDictMapper {
    int deleteByPrimaryKey(String titleCode);

    int insert(TitleDict record);

    int insertSelective(TitleDict record);

    TitleDict selectByPrimaryKey(String titleCode);

    int updateByPrimaryKeySelective(TitleDict record);

    int updateByPrimaryKey(TitleDict record);
}