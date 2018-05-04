package com.ht.extra.dao;

import com.ht.extra.pojo.comm.BillingGroupDict;

public interface BillingGroupDictMapper {
    int deleteByPrimaryKey(String groupName);

    int insert(BillingGroupDict record);

    int insertSelective(BillingGroupDict record);

    BillingGroupDict selectByPrimaryKey(String groupName);

    int updateByPrimaryKeySelective(BillingGroupDict record);

    int updateByPrimaryKey(BillingGroupDict record);
}