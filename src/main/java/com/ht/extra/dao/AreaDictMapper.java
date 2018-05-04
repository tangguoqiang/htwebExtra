package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AreaDict;

public interface AreaDictMapper {
    int deleteByPrimaryKey(String areaCode);

    int insert(AreaDict record);

    int insertSelective(AreaDict record);

    AreaDict selectByPrimaryKey(String areaCode);

    int updateByPrimaryKeySelective(AreaDict record);

    int updateByPrimaryKey(AreaDict record);
}