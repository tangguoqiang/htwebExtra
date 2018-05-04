package com.ht.extra.dao;

import com.ht.extra.pojo.ordadm.Orders;
import com.ht.extra.pojo.ordadm.OrdersKey;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(OrdersKey key);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(OrdersKey key);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> selectByPatient(OrdersKey key);
}