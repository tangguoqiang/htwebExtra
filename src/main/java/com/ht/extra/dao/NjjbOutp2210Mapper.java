package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.NjjbOutp2210;
import com.ht.extra.pojo.insurance.NjjbOutp2210Key;

public interface NjjbOutp2210Mapper {
    int deleteByPrimaryKey(NjjbOutp2210Key key);

    int insert(NjjbOutp2210 record);

    int insertSelective(NjjbOutp2210 record);

    NjjbOutp2210 selectByPrimaryKey(NjjbOutp2210Key key);

    int updateByPrimaryKeySelective(NjjbOutp2210 record);

    int updateByPrimaryKey(NjjbOutp2210 record);
}