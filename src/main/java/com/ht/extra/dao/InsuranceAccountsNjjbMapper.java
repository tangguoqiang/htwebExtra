package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuranceAccountsNjjb;
import com.ht.extra.pojo.insurance.InsuranceAccountsNjjbKey;

public interface InsuranceAccountsNjjbMapper {
    int deleteByPrimaryKey(InsuranceAccountsNjjbKey key);

    int insert(InsuranceAccountsNjjb record);

    int insertSelective(InsuranceAccountsNjjb record);

    InsuranceAccountsNjjb selectByPrimaryKey(InsuranceAccountsNjjbKey key);

    int updateByPrimaryKeySelective(InsuranceAccountsNjjb record);

    int updateByPrimaryKey(InsuranceAccountsNjjb record);
}