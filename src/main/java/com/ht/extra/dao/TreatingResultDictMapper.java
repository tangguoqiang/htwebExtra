package com.ht.extra.dao;

import com.ht.extra.pojo.comm.TreatingResultDict;

public interface TreatingResultDictMapper {
    int deleteByPrimaryKey(String treatingResultName);

    int insert(TreatingResultDict record);

    int insertSelective(TreatingResultDict record);

    TreatingResultDict selectByPrimaryKey(String treatingResultName);

    int updateByPrimaryKeySelective(TreatingResultDict record);

    int updateByPrimaryKey(TreatingResultDict record);
}