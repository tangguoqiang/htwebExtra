package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OperationCodeCompare;
import com.ht.extra.pojo.comm.OperationCodeCompareKey;

public interface OperationCodeCompareMapper {
    int deleteByPrimaryKey(OperationCodeCompareKey key);

    int insert(OperationCodeCompare record);

    int insertSelective(OperationCodeCompare record);

    OperationCodeCompare selectByPrimaryKey(OperationCodeCompareKey key);

    int updateByPrimaryKeySelective(OperationCodeCompare record);

    int updateByPrimaryKey(OperationCodeCompare record);
}