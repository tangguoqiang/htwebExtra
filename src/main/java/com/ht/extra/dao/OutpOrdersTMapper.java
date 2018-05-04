package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.OutpOrdersT;

import java.util.List;

public interface OutpOrdersTMapper {
    int deleteByPrimaryKey(String serialNo);

    int insert(OutpOrdersT record);

    int insertSelective(OutpOrdersT record);

    OutpOrdersT selectByPrimaryKey(String serialNo);

    List<OutpOrdersT> selectByPrimaryKeyForZF(String patient, String changeType);

    List<OutpOrdersT> selectByPrimaryKeyForZZJ(String patient);

    int updateByPrimaryKeySelective(OutpOrdersT record);

    int updateByPrimaryKey(OutpOrdersT record);
}