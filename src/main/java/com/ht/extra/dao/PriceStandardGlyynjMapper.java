package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PriceStandardGlyynj;

public interface PriceStandardGlyynjMapper {
    int deleteByPrimaryKey(String itemNo);

    int insert(PriceStandardGlyynj record);

    int insertSelective(PriceStandardGlyynj record);

    PriceStandardGlyynj selectByPrimaryKey(String itemNo);

    int updateByPrimaryKeySelective(PriceStandardGlyynj record);

    int updateByPrimaryKey(PriceStandardGlyynj record);
}