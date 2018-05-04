package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PhamBasicInfo;

public interface PhamBasicInfoMapper {
    int deleteByPrimaryKey(String phamStdCode);

    int insert(PhamBasicInfo record);

    int insertSelective(PhamBasicInfo record);

    PhamBasicInfo selectByPrimaryKey(String phamStdCode);

    int updateByPrimaryKeySelective(PhamBasicInfo record);

    int updateByPrimaryKey(PhamBasicInfo record);
}