package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PriceStandardJswj;

public interface PriceStandardJswjMapper {
    int deleteByPrimaryKey(String itemCode);

    int insert(PriceStandardJswj record);

    int insertSelective(PriceStandardJswj record);

    PriceStandardJswj selectByPrimaryKey(String itemCode);

    int updateByPrimaryKeySelective(PriceStandardJswj record);

    int updateByPrimaryKey(PriceStandardJswj record);
}