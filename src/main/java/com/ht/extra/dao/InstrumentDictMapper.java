package com.ht.extra.dao;

import com.ht.extra.pojo.lab.InstrumentDict;

public interface InstrumentDictMapper {
    int deleteByPrimaryKey(String instId);

    int insert(InstrumentDict record);

    int insertSelective(InstrumentDict record);

    InstrumentDict selectByPrimaryKey(String instId);

    int updateByPrimaryKeySelective(InstrumentDict record);

    int updateByPrimaryKey(InstrumentDict record);
}