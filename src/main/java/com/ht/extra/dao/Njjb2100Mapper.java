package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.Njjb2100;

public interface Njjb2100Mapper {
    int deleteByPrimaryKey(String insuranceNo);

    int insert(Njjb2100 record);

    int insertSelective(Njjb2100 record);

    Njjb2100 selectByPrimaryKey(String insuranceNo);

    int updateByPrimaryKeySelective(Njjb2100 record);

    int updateByPrimaryKey(Njjb2100 record);
}