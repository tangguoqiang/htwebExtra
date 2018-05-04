package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ClassCodingRule;
import com.ht.extra.pojo.comm.ClassCodingRuleKey;

public interface ClassCodingRuleMapper {
    int deleteByPrimaryKey(ClassCodingRuleKey key);

    int insert(ClassCodingRule record);

    int insertSelective(ClassCodingRule record);

    ClassCodingRule selectByPrimaryKey(ClassCodingRuleKey key);

    int updateByPrimaryKeySelective(ClassCodingRule record);

    int updateByPrimaryKey(ClassCodingRule record);
}