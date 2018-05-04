package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugInfo;

public interface DrugInfoMapper {
    int deleteByPrimaryKey(String drugCode);

    int insert(DrugInfo record);

    int insertSelective(DrugInfo record);

    DrugInfo selectByPrimaryKey(String drugCode);

    int updateByPrimaryKeySelective(DrugInfo record);

    int updateByPrimaryKey(DrugInfo record);
}