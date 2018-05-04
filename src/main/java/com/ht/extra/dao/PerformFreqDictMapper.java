package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PerformFreqDict;

public interface PerformFreqDictMapper {
    int deleteByPrimaryKey(String freqDesc);

    int insert(PerformFreqDict record);

    int insertSelective(PerformFreqDict record);

    PerformFreqDict selectByPrimaryKey(String freqDesc);

    int updateByPrimaryKeySelective(PerformFreqDict record);

    int updateByPrimaryKey(PerformFreqDict record);
}