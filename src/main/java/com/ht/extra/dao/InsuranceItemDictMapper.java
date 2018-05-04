package com.ht.extra.dao;

import com.ht.extra.pojo.comm.InsuranceItemDict;
import com.ht.extra.pojo.comm.InsuranceItemDictKey;

public interface InsuranceItemDictMapper {
    int deleteByPrimaryKey(InsuranceItemDictKey key);

    int insert(InsuranceItemDict record);

    int insertSelective(InsuranceItemDict record);

    InsuranceItemDict selectByPrimaryKey(InsuranceItemDictKey key);

    int updateByPrimaryKeySelective(InsuranceItemDict record);

    int updateByPrimaryKey(InsuranceItemDict record);
}