package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PrepayTransTypeDict;

public interface PrepayTransTypeDictMapper {
    int deleteByPrimaryKey(String transactTypeCode);

    int insert(PrepayTransTypeDict record);

    int insertSelective(PrepayTransTypeDict record);

    PrepayTransTypeDict selectByPrimaryKey(String transactTypeCode);

    int updateByPrimaryKeySelective(PrepayTransTypeDict record);

    int updateByPrimaryKey(PrepayTransTypeDict record);
}