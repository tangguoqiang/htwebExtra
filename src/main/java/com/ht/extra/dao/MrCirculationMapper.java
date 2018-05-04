package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MrCirculation;
import com.ht.extra.pojo.medrec.MrCirculationKey;

public interface MrCirculationMapper {
    int deleteByPrimaryKey(MrCirculationKey key);

    int insert(MrCirculation record);

    int insertSelective(MrCirculation record);

    MrCirculation selectByPrimaryKey(MrCirculationKey key);

    int updateByPrimaryKeySelective(MrCirculation record);

    int updateByPrimaryKey(MrCirculation record);
}