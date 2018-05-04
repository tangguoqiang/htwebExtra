package com.ht.extra.dao;

import com.ht.extra.pojo.comm.IsolationIndicatorDict;

public interface IsolationIndicatorDictMapper {
    int deleteByPrimaryKey(Short isolationIndicatorCode);

    int insert(IsolationIndicatorDict record);

    int insertSelective(IsolationIndicatorDict record);

    IsolationIndicatorDict selectByPrimaryKey(Short isolationIndicatorCode);

    int updateByPrimaryKeySelective(IsolationIndicatorDict record);

    int updateByPrimaryKey(IsolationIndicatorDict record);
}