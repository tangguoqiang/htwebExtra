package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.OutpOrderDescBack;
import com.ht.extra.pojo.outpbill.OutpOrderDescBackKey;

public interface OutpOrderDescBackMapper {
    int deleteByPrimaryKey(OutpOrderDescBackKey key);

    int insert(OutpOrderDescBack record);

    int insertSelective(OutpOrderDescBack record);

    OutpOrderDescBack selectByPrimaryKey(OutpOrderDescBackKey key);

    int updateByPrimaryKeySelective(OutpOrderDescBack record);

    int updateByPrimaryKey(OutpOrderDescBack record);
}