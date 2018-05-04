package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.UnsettleRec;
import com.ht.extra.pojo.inpbill.UnsettleRecKey;

public interface UnsettleRecMapper {
    int deleteByPrimaryKey(UnsettleRecKey key);

    int insert(UnsettleRec record);

    int insertSelective(UnsettleRec record);

    UnsettleRec selectByPrimaryKey(UnsettleRecKey key);

    int updateByPrimaryKeySelective(UnsettleRec record);

    int updateByPrimaryKey(UnsettleRec record);
}