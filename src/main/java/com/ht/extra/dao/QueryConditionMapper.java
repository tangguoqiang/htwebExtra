package com.ht.extra.dao;

import com.ht.extra.pojo.comm.QueryCondition;
import com.ht.extra.pojo.comm.QueryConditionKey;

public interface QueryConditionMapper {
    int deleteByPrimaryKey(QueryConditionKey key);

    int insert(QueryCondition record);

    int insertSelective(QueryCondition record);

    QueryCondition selectByPrimaryKey(QueryConditionKey key);

    int updateByPrimaryKeySelective(QueryCondition record);

    int updateByPrimaryKey(QueryCondition record);
}