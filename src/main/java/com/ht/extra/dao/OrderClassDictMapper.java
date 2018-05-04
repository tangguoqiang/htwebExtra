package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OrderClassDict;

public interface OrderClassDictMapper {
    int deleteByPrimaryKey(String orderClassCode);

    int insert(OrderClassDict record);

    int insertSelective(OrderClassDict record);

    OrderClassDict selectByPrimaryKey(String orderClassCode);

    int updateByPrimaryKeySelective(OrderClassDict record);

    int updateByPrimaryKey(OrderClassDict record);
}