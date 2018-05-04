package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.PatIccardRecNew;

public interface PatIccardRecNewMapper {
    int deleteByPrimaryKey(String iccardNo);

    int insert(PatIccardRecNew record);

    int insertSelective(PatIccardRecNew record);

    PatIccardRecNew selectByPrimaryKey(String iccardNo);

    int updateByPrimaryKeySelective(PatIccardRecNew record);

    int updateByPrimaryKey(PatIccardRecNew record);
}