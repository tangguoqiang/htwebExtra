package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ChargetypeVsMedpayway;
import com.ht.extra.pojo.comm.ChargetypeVsMedpaywayKey;

public interface ChargetypeVsMedpaywayMapper {
    int deleteByPrimaryKey(ChargetypeVsMedpaywayKey key);

    int insert(ChargetypeVsMedpayway record);

    int insertSelective(ChargetypeVsMedpayway record);

    ChargetypeVsMedpayway selectByPrimaryKey(ChargetypeVsMedpaywayKey key);

    int updateByPrimaryKeySelective(ChargetypeVsMedpayway record);

    int updateByPrimaryKey(ChargetypeVsMedpayway record);
}