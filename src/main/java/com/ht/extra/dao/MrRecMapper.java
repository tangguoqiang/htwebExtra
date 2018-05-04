package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MrRec;
import com.ht.extra.pojo.medrec.MrRecKey;

public interface MrRecMapper {
    int deleteByPrimaryKey(MrRecKey key);

    int insert(MrRec record);

    int insertSelective(MrRec record);

    MrRec selectByPrimaryKey(MrRecKey key);

    int updateByPrimaryKeySelective(MrRec record);

    int updateByPrimaryKey(MrRec record);
}