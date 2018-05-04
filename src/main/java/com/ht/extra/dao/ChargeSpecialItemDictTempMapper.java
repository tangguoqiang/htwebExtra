package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ChargeSpecialItemDictTemp;
import com.ht.extra.pojo.comm.ChargeSpecialItemDictTempKey;

public interface ChargeSpecialItemDictTempMapper {
    int deleteByPrimaryKey(ChargeSpecialItemDictTempKey key);

    int insert(ChargeSpecialItemDictTemp record);

    int insertSelective(ChargeSpecialItemDictTemp record);

    ChargeSpecialItemDictTemp selectByPrimaryKey(ChargeSpecialItemDictTempKey key);

    int updateByPrimaryKeySelective(ChargeSpecialItemDictTemp record);

    int updateByPrimaryKey(ChargeSpecialItemDictTemp record);
}