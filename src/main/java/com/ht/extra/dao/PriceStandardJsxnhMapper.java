package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PriceStandardJsxnh;

public interface PriceStandardJsxnhMapper {
    int deleteByPrimaryKey(String itemNo);

    int insert(PriceStandardJsxnh record);

    int insertSelective(PriceStandardJsxnh record);

    PriceStandardJsxnh selectByPrimaryKey(String itemNo);

    int updateByPrimaryKeySelective(PriceStandardJsxnh record);

    int updateByPrimaryKey(PriceStandardJsxnh record);
}