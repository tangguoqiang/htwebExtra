package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.InternetPayinfo;

public interface InternetPayinfoMapper {
    int deleteByPrimaryKey(String tradeNo);

    int insert(InternetPayinfo record);

    int insertSelective(InternetPayinfo record);

    InternetPayinfo selectByPrimaryKey(String tradeNo);

    int updateByPrimaryKeySelective(InternetPayinfo record);

    int updateByPrimaryKey(InternetPayinfo record);
}