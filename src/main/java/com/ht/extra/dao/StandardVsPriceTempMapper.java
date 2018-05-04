package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StandardVsPriceTemp;

public interface StandardVsPriceTempMapper {
    int deleteByPrimaryKey(Integer serialNo);

    int insert(StandardVsPriceTemp record);

    int insertSelective(StandardVsPriceTemp record);

    StandardVsPriceTemp selectByPrimaryKey(Integer serialNo);

    int updateByPrimaryKeySelective(StandardVsPriceTemp record);

    int updateByPrimaryKey(StandardVsPriceTemp record);
}