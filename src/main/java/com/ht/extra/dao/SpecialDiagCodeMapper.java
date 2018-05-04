package com.ht.extra.dao;

import com.ht.extra.pojo.comm.SpecialDiagCode;

public interface SpecialDiagCodeMapper {
    int deleteByPrimaryKey(String specialDiagName);

    int insert(SpecialDiagCode record);

    int insertSelective(SpecialDiagCode record);

    SpecialDiagCode selectByPrimaryKey(String specialDiagName);

    int updateByPrimaryKeySelective(SpecialDiagCode record);

    int updateByPrimaryKey(SpecialDiagCode record);
}