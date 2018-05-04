package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuVsPriceNew;
import com.ht.extra.pojo.insurance.InsuVsPriceNewKey;

public interface InsuVsPriceNewMapper {
    int deleteByPrimaryKey(InsuVsPriceNewKey key);

    int insert(InsuVsPriceNew record);

    int insertSelective(InsuVsPriceNew record);

    InsuVsPriceNew selectByPrimaryKey(InsuVsPriceNewKey key);

    int updateByPrimaryKeySelective(InsuVsPriceNew record);

    int updateByPrimaryKey(InsuVsPriceNew record);
}