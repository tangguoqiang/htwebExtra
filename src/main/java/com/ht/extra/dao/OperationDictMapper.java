package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OperationDict;

public interface OperationDictMapper {
    int deleteByPrimaryKey(String operationName);

    int insert(OperationDict record);

    int insertSelective(OperationDict record);

    OperationDict selectByPrimaryKey(String operationName);

    int updateByPrimaryKeySelective(OperationDict record);

    int updateByPrimaryKey(OperationDict record);
}