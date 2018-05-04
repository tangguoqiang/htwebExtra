package com.ht.extra.dao;

import com.ht.extra.pojo.comm.CostItemClassDict;

public interface CostItemClassDictMapper {
    int deleteByPrimaryKey(String classCode);

    int insert(CostItemClassDict record);

    int insertSelective(CostItemClassDict record);

    CostItemClassDict selectByPrimaryKey(String classCode);

    int updateByPrimaryKeySelective(CostItemClassDict record);

    int updateByPrimaryKey(CostItemClassDict record);
}