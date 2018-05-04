package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PoliclinicTypeDict;

public interface PoliclinicTypeDictMapper {
    int deleteByPrimaryKey(String type);

    int insert(PoliclinicTypeDict record);

    int insertSelective(PoliclinicTypeDict record);

    PoliclinicTypeDict selectByPrimaryKey(String type);

    int updateByPrimaryKeySelective(PoliclinicTypeDict record);

    int updateByPrimaryKey(PoliclinicTypeDict record);
}