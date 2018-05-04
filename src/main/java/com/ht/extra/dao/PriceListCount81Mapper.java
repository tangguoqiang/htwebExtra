package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PriceListCount81;
import com.ht.extra.pojo.comm.PriceListCount81Key;

public interface PriceListCount81Mapper {
    int deleteByPrimaryKey(PriceListCount81Key key);

    int insert(PriceListCount81 record);

    int insertSelective(PriceListCount81 record);

    PriceListCount81 selectByPrimaryKey(PriceListCount81Key key);

    int updateByPrimaryKeySelective(PriceListCount81 record);

    int updateByPrimaryKey(PriceListCount81 record);
}