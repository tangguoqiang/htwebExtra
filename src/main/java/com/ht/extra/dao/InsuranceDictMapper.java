package com.ht.extra.dao;

import com.ht.extra.pojo.comm.InsuranceDict;

public interface InsuranceDictMapper {
    int deleteByPrimaryKey(Integer insuNo);

    int insert(InsuranceDict record);

    int insertSelective(InsuranceDict record);

    InsuranceDict selectByPrimaryKey(Integer insuNo);

    int updateByPrimaryKeySelective(InsuranceDict record);

    int updateByPrimaryKey(InsuranceDict record);
}