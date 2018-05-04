package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PriceItemNameDict;
import com.ht.extra.pojo.comm.PriceItemNameDictKey;

public interface PriceItemNameDictMapper {
    int deleteByPrimaryKey(PriceItemNameDictKey key);

    int insert(PriceItemNameDict record);

    int insertSelective(PriceItemNameDict record);

    PriceItemNameDict selectByPrimaryKey(PriceItemNameDictKey key);

    int updateByPrimaryKeySelective(PriceItemNameDict record);

    int updateByPrimaryKey(PriceItemNameDict record);
}