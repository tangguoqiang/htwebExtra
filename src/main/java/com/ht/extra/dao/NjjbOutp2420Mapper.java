package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.NjjbOutp2420;
import com.ht.extra.pojo.insurance.NjjbOutp2420Key;

public interface NjjbOutp2420Mapper {
    int deleteByPrimaryKey(NjjbOutp2420Key key);

    int insert(NjjbOutp2420 record);

    int insertSelective(NjjbOutp2420 record);

    NjjbOutp2420 selectByPrimaryKey(NjjbOutp2420Key key);

    int updateByPrimaryKeySelective(NjjbOutp2420 record);

    int updateByPrimaryKey(NjjbOutp2420 record);
}