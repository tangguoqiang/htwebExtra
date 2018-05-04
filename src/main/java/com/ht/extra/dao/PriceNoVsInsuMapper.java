package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PriceNoVsInsu;
import com.ht.extra.pojo.comm.PriceNoVsInsuKey;

public interface PriceNoVsInsuMapper {
    int deleteByPrimaryKey(PriceNoVsInsuKey key);

    int insert(PriceNoVsInsu record);

    int insertSelective(PriceNoVsInsu record);

    PriceNoVsInsu selectByPrimaryKey(PriceNoVsInsuKey key);

    int updateByPrimaryKeySelective(PriceNoVsInsu record);

    int updateByPrimaryKey(PriceNoVsInsu record);
}