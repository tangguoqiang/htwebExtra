package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.OutpMr;
import com.ht.extra.pojo.outpdoct.OutpMrKey;

public interface OutpMrMapper {
    int deleteByPrimaryKey(OutpMrKey key);

    int insert(OutpMr record);

    int insertSelective(OutpMr record);

    OutpMr selectByPrimaryKey(OutpMrKey key);

    int updateByPrimaryKeySelective(OutpMr record);

    int updateByPrimaryKey(OutpMr record);
}