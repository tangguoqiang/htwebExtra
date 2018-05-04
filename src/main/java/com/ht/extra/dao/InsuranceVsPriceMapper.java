package com.ht.extra.dao;

import com.ht.extra.pojo.comm.InsuranceVsPrice;

public interface InsuranceVsPriceMapper {
    int deleteByPrimaryKey(Integer insuNo);

    int insert(InsuranceVsPrice record);

    int insertSelective(InsuranceVsPrice record);

    InsuranceVsPrice selectByPrimaryKey(Integer insuNo);

    int updateByPrimaryKeySelective(InsuranceVsPrice record);

    int updateByPrimaryKey(InsuranceVsPrice record);
}