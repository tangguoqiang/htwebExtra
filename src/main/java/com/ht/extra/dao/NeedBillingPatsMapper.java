package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.NeedBillingPats;

public interface NeedBillingPatsMapper {
    int deleteByPrimaryKey(String patientId);

    int insert(NeedBillingPats record);

    int insertSelective(NeedBillingPats record);

    NeedBillingPats selectByPrimaryKey(String patientId);

    int updateByPrimaryKeySelective(NeedBillingPats record);

    int updateByPrimaryKey(NeedBillingPats record);
}