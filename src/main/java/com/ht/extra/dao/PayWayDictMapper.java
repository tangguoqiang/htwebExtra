package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PayWayDict;

public interface PayWayDictMapper {
    int deleteByPrimaryKey(String payWayCode);

    int insert(PayWayDict record);

    int insertSelective(PayWayDict record);

    PayWayDict selectByPrimaryKey(String payWayCode);

    int updateByPrimaryKeySelective(PayWayDict record);

    int updateByPrimaryKey(PayWayDict record);
}