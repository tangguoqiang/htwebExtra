package com.ht.extra.dao;

import com.ht.extra.pojo.comm.SettleTransTypeDict;

public interface SettleTransTypeDictMapper {
    int deleteByPrimaryKey(String transactTypeCode);

    int insert(SettleTransTypeDict record);

    int insertSelective(SettleTransTypeDict record);

    SettleTransTypeDict selectByPrimaryKey(String transactTypeCode);

    int updateByPrimaryKeySelective(SettleTransTypeDict record);

    int updateByPrimaryKey(SettleTransTypeDict record);
}