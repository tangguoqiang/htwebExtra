package com.ht.extra.dao;

import com.ht.extra.pojo.comm.CountryDict;

public interface CountryDictMapper {
    int deleteByPrimaryKey(String countryCode);

    int insert(CountryDict record);

    int insertSelective(CountryDict record);

    CountryDict selectByPrimaryKey(String countryCode);

    int updateByPrimaryKeySelective(CountryDict record);

    int updateByPrimaryKey(CountryDict record);
}