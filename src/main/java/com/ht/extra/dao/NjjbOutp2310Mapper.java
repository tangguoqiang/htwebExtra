package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.NjjbOutp2310;
import com.ht.extra.pojo.insurance.NjjbOutp2310Key;

public interface NjjbOutp2310Mapper {
    int deleteByPrimaryKey(NjjbOutp2310Key key);

    int insert(NjjbOutp2310 record);

    int insertSelective(NjjbOutp2310 record);

    NjjbOutp2310 selectByPrimaryKey(NjjbOutp2310Key key);

    int updateByPrimaryKeySelective(NjjbOutp2310 record);

    int updateByPrimaryKey(NjjbOutp2310 record);
}