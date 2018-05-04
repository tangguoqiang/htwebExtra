package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ChargeSpecialItemDict;
import com.ht.extra.pojo.comm.ChargeSpecialItemDictKey;

public interface ChargeSpecialItemDictMapper {
    int deleteByPrimaryKey(ChargeSpecialItemDictKey key);

    int insert(ChargeSpecialItemDict record);

    int insertSelective(ChargeSpecialItemDict record);

    ChargeSpecialItemDict selectByPrimaryKey(ChargeSpecialItemDictKey key);

    int updateByPrimaryKeySelective(ChargeSpecialItemDict record);

    int updateByPrimaryKey(ChargeSpecialItemDict record);
}