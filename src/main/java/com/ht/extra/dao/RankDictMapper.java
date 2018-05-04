package com.ht.extra.dao;

import com.ht.extra.pojo.comm.RankDict;

public interface RankDictMapper {
    int deleteByPrimaryKey(String rankName);

    int insert(RankDict record);

    int insertSelective(RankDict record);

    RankDict selectByPrimaryKey(String rankName);

    int updateByPrimaryKeySelective(RankDict record);

    int updateByPrimaryKey(RankDict record);
}