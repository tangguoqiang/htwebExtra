package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugCodingRule;

public interface DrugCodingRuleMapper {
    int deleteByPrimaryKey(Short codeLevel);

    int insert(DrugCodingRule record);

    int insertSelective(DrugCodingRule record);

    DrugCodingRule selectByPrimaryKey(Short codeLevel);

    int updateByPrimaryKeySelective(DrugCodingRule record);

    int updateByPrimaryKey(DrugCodingRule record);
}