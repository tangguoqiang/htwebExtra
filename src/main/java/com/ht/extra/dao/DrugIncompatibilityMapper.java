package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugIncompatibility;
import com.ht.extra.pojo.comm.DrugIncompatibilityKey;

public interface DrugIncompatibilityMapper {
    int deleteByPrimaryKey(DrugIncompatibilityKey key);

    int insert(DrugIncompatibility record);

    int insertSelective(DrugIncompatibility record);

    DrugIncompatibility selectByPrimaryKey(DrugIncompatibilityKey key);

    int updateByPrimaryKeySelective(DrugIncompatibility record);

    int updateByPrimaryKey(DrugIncompatibility record);
}