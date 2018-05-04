package com.ht.extra.dao;

import com.ht.extra.pojo.comm.BedTypeDict;

public interface BedTypeDictMapper {
    int deleteByPrimaryKey(String bedTypeCode);

    int insert(BedTypeDict record);

    int insertSelective(BedTypeDict record);

    BedTypeDict selectByPrimaryKey(String bedTypeCode);

    int updateByPrimaryKeySelective(BedTypeDict record);

    int updateByPrimaryKey(BedTypeDict record);
}