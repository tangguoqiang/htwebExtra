package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.BindingPrescDetail;
import com.ht.extra.pojo.outpdoct.BindingPrescDetailKey;

public interface BindingPrescDetailMapper {
    int deleteByPrimaryKey(BindingPrescDetailKey key);

    int insert(BindingPrescDetail record);

    int insertSelective(BindingPrescDetail record);

    BindingPrescDetail selectByPrimaryKey(BindingPrescDetailKey key);

    int updateByPrimaryKeySelective(BindingPrescDetail record);

    int updateByPrimaryKey(BindingPrescDetail record);
}