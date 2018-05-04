package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PhamBasicTemp;

public interface PhamBasicTempMapper {
    int deleteByPrimaryKey(String phamStdCode);

    int insert(PhamBasicTemp record);

    int insertSelective(PhamBasicTemp record);

    PhamBasicTemp selectByPrimaryKey(String phamStdCode);

    int updateByPrimaryKeySelective(PhamBasicTemp record);

    int updateByPrimaryKey(PhamBasicTemp record);
}