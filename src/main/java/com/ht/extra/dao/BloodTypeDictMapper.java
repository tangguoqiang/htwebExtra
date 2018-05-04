package com.ht.extra.dao;

import com.ht.extra.pojo.comm.BloodTypeDict;

public interface BloodTypeDictMapper {
    int deleteByPrimaryKey(String bloodTypeName);

    int insert(BloodTypeDict record);

    int insertSelective(BloodTypeDict record);

    BloodTypeDict selectByPrimaryKey(String bloodTypeName);

    int updateByPrimaryKeySelective(BloodTypeDict record);

    int updateByPrimaryKey(BloodTypeDict record);
}