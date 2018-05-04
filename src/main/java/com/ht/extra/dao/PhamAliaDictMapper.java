package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PhamAliaDict;
import com.ht.extra.pojo.comm.PhamAliaDictKey;

public interface PhamAliaDictMapper {
    int deleteByPrimaryKey(PhamAliaDictKey key);

    int insert(PhamAliaDict record);

    int insertSelective(PhamAliaDict record);

    PhamAliaDict selectByPrimaryKey(PhamAliaDictKey key);

    int updateByPrimaryKeySelective(PhamAliaDict record);

    int updateByPrimaryKey(PhamAliaDict record);
}