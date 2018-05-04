package com.ht.extra.dao;

import com.ht.extra.pojo.comm.BedApprovedTypeDict;

public interface BedApprovedTypeDictMapper {
    int deleteByPrimaryKey(String bedApprovedTypeCode);

    int insert(BedApprovedTypeDict record);

    int insertSelective(BedApprovedTypeDict record);

    BedApprovedTypeDict selectByPrimaryKey(String bedApprovedTypeCode);

    int updateByPrimaryKeySelective(BedApprovedTypeDict record);

    int updateByPrimaryKey(BedApprovedTypeDict record);
}