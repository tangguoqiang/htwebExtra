package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.OutpOrders;

public interface OutpOrdersMapper {
    int deleteByPrimaryKey(String serialNo);

    int insert(OutpOrders record);

    int insertSelective(OutpOrders record);

    OutpOrders selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(OutpOrders record);

    int updateByPrimaryKey(OutpOrders record);
}