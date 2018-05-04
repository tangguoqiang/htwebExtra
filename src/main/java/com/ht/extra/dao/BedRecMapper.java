package com.ht.extra.dao;

import com.ht.extra.pojo.inpadm.BedRec;
import com.ht.extra.pojo.inpadm.BedRecKey;

public interface BedRecMapper {
    int deleteByPrimaryKey(BedRecKey key);

    int insert(BedRec record);

    int insertSelective(BedRec record);

    BedRec selectByPrimaryKey(BedRecKey key);

    int updateByPrimaryKeySelective(BedRec record);

    int updateByPrimaryKey(BedRec record);
}