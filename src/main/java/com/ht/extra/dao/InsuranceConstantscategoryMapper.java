package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuranceConstantscategory;
import com.ht.extra.pojo.insurance.InsuranceConstantscategoryKey;

public interface InsuranceConstantscategoryMapper {
    int deleteByPrimaryKey(InsuranceConstantscategoryKey key);

    int insert(InsuranceConstantscategory record);

    int insertSelective(InsuranceConstantscategory record);

    InsuranceConstantscategory selectByPrimaryKey(InsuranceConstantscategoryKey key);

    int updateByPrimaryKeySelective(InsuranceConstantscategory record);

    int updateByPrimaryKey(InsuranceConstantscategory record);
}