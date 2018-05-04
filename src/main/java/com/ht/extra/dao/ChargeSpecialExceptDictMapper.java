package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ChargeSpecialExceptDict;
import com.ht.extra.pojo.comm.ChargeSpecialExceptDictKey;

public interface ChargeSpecialExceptDictMapper {
    int deleteByPrimaryKey(ChargeSpecialExceptDictKey key);

    int insert(ChargeSpecialExceptDict record);

    int insertSelective(ChargeSpecialExceptDict record);

    ChargeSpecialExceptDict selectByPrimaryKey(ChargeSpecialExceptDictKey key);

    int updateByPrimaryKeySelective(ChargeSpecialExceptDict record);

    int updateByPrimaryKey(ChargeSpecialExceptDict record);
}