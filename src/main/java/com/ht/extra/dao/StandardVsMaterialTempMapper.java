package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StandardVsMaterialTemp;

public interface StandardVsMaterialTempMapper {
    int deleteByPrimaryKey(Integer serialNo);

    int insert(StandardVsMaterialTemp record);

    int insertSelective(StandardVsMaterialTemp record);

    StandardVsMaterialTemp selectByPrimaryKey(Integer serialNo);

    int updateByPrimaryKeySelective(StandardVsMaterialTemp record);

    int updateByPrimaryKey(StandardVsMaterialTemp record);
}