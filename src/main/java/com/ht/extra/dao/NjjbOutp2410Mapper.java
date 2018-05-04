package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.NjjbOutp2410;

public interface NjjbOutp2410Mapper {
    int deleteByPrimaryKey(String rcptNo);

    int insert(NjjbOutp2410 record);

    int insertSelective(NjjbOutp2410 record);

    NjjbOutp2410 selectByPrimaryKey(String rcptNo);

    int updateByPrimaryKeySelective(NjjbOutp2410 record);

    int updateByPrimaryKey(NjjbOutp2410 record);
}