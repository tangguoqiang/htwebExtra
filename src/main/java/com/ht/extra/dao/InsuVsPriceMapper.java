package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuVsPrice;
import com.ht.extra.pojo.insurance.InsuVsPriceKey;

public interface InsuVsPriceMapper {
    int deleteByPrimaryKey(InsuVsPriceKey key);

    int insert(InsuVsPrice record);

    int insertSelective(InsuVsPrice record);

    InsuVsPrice selectByPrimaryKey(InsuVsPriceKey key);

    int updateByPrimaryKeySelective(InsuVsPrice record);

    int updateByPrimaryKey(InsuVsPrice record);
}