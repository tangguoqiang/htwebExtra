package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuranceInterfaceDict;

public interface InsuranceInterfaceDictMapper {
    int deleteByPrimaryKey(String interfacecode);

    int insert(InsuranceInterfaceDict record);

    int insertSelective(InsuranceInterfaceDict record);

    InsuranceInterfaceDict selectByPrimaryKey(String interfacecode);

    int updateByPrimaryKeySelective(InsuranceInterfaceDict record);

    int updateByPrimaryKey(InsuranceInterfaceDict record);
}