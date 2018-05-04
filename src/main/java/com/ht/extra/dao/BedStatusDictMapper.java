package com.ht.extra.dao;

import com.ht.extra.pojo.comm.BedStatusDict;

public interface BedStatusDictMapper {
    int deleteByPrimaryKey(String bedStatusCode);

    int insert(BedStatusDict record);

    int insertSelective(BedStatusDict record);

    BedStatusDict selectByPrimaryKey(String bedStatusCode);

    int updateByPrimaryKeySelective(BedStatusDict record);

    int updateByPrimaryKey(BedStatusDict record);
}