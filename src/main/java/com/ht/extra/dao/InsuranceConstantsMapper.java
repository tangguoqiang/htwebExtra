package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuranceConstants;
import com.ht.extra.pojo.insurance.InsuranceConstantsKey;

public interface InsuranceConstantsMapper {
    int deleteByPrimaryKey(InsuranceConstantsKey key);

    int insert(InsuranceConstants record);

    int insertSelective(InsuranceConstants record);

    InsuranceConstants selectByPrimaryKey(InsuranceConstantsKey key);

    int updateByPrimaryKeySelective(InsuranceConstants record);

    int updateByPrimaryKey(InsuranceConstants record);
}