package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OldOperationDict;

public interface OldOperationDictMapper {
    int deleteByPrimaryKey(String operationName);

    int insert(OldOperationDict record);

    int insertSelective(OldOperationDict record);

    OldOperationDict selectByPrimaryKey(String operationName);

    int updateByPrimaryKeySelective(OldOperationDict record);

    int updateByPrimaryKey(OldOperationDict record);
}