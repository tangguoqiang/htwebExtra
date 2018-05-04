package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AnaesthesiaDict;

public interface AnaesthesiaDictMapper {
    int deleteByPrimaryKey(String anaesthesiaName);

    int insert(AnaesthesiaDict record);

    int insertSelective(AnaesthesiaDict record);

    AnaesthesiaDict selectByPrimaryKey(String anaesthesiaName);

    int updateByPrimaryKeySelective(AnaesthesiaDict record);

    int updateByPrimaryKey(AnaesthesiaDict record);
}