package com.ht.extra.dao;

import com.ht.extra.pojo.comm.MrQualityDict;

public interface MrQualityDictMapper {
    int deleteByPrimaryKey(String mrQualityName);

    int insert(MrQualityDict record);

    int insertSelective(MrQualityDict record);

    MrQualityDict selectByPrimaryKey(String mrQualityName);

    int updateByPrimaryKeySelective(MrQualityDict record);

    int updateByPrimaryKey(MrQualityDict record);
}