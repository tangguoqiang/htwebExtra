package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OrderStatusDict;

public interface OrderStatusDictMapper {
    int deleteByPrimaryKey(String orderStatusCode);

    int insert(OrderStatusDict record);

    int insertSelective(OrderStatusDict record);

    OrderStatusDict selectByPrimaryKey(String orderStatusCode);

    int updateByPrimaryKeySelective(OrderStatusDict record);

    int updateByPrimaryKey(OrderStatusDict record);
}