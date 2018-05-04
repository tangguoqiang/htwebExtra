package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DataVerifyCondition;
import com.ht.extra.pojo.comm.DataVerifyConditionKey;

public interface DataVerifyConditionMapper {
    int deleteByPrimaryKey(DataVerifyConditionKey key);

    int insert(DataVerifyCondition record);

    int insertSelective(DataVerifyCondition record);

    DataVerifyCondition selectByPrimaryKey(DataVerifyConditionKey key);

    int updateByPrimaryKeySelective(DataVerifyCondition record);

    int updateByPrimaryKey(DataVerifyCondition record);
}