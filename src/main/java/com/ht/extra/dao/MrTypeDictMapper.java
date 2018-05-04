package com.ht.extra.dao;

import com.ht.extra.pojo.comm.MrTypeDict;

public interface MrTypeDictMapper {
    int deleteByPrimaryKey(String mrTypeCode);

    int insert(MrTypeDict record);

    int insertSelective(MrTypeDict record);

    MrTypeDict selectByPrimaryKey(String mrTypeCode);

    int updateByPrimaryKeySelective(MrTypeDict record);

    int updateByPrimaryKey(MrTypeDict record);
}