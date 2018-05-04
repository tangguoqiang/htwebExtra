package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugPriceList;
import com.ht.extra.pojo.comm.DrugPriceListKey;

public interface DrugPriceListMapper {
    int deleteByPrimaryKey(DrugPriceListKey key);

    int insert(DrugPriceList record);

    int insertSelective(DrugPriceList record);

    DrugPriceList selectByPrimaryKey(DrugPriceListKey key);

    int updateByPrimaryKeySelective(DrugPriceList record);

    int updateByPrimaryKey(DrugPriceList record);
}