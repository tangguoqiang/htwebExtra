package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OperationScaleDict;

public interface OperationScaleDictMapper {
    int deleteByPrimaryKey(String operationScaleCode);

    int insert(OperationScaleDict record);

    int insertSelective(OperationScaleDict record);

    OperationScaleDict selectByPrimaryKey(String operationScaleCode);

    int updateByPrimaryKeySelective(OperationScaleDict record);

    int updateByPrimaryKey(OperationScaleDict record);
}