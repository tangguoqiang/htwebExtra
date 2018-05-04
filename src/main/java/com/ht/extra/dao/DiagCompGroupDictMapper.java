package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DiagCompGroupDict;

public interface DiagCompGroupDictMapper {
    int deleteByPrimaryKey(String diagCompGroupCode);

    int insert(DiagCompGroupDict record);

    int insertSelective(DiagCompGroupDict record);

    DiagCompGroupDict selectByPrimaryKey(String diagCompGroupCode);

    int updateByPrimaryKeySelective(DiagCompGroupDict record);

    int updateByPrimaryKey(DiagCompGroupDict record);
}