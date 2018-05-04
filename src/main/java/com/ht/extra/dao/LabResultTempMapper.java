package com.ht.extra.dao;

import com.ht.extra.pojo.lab.LabResultTemp;
import com.ht.extra.pojo.lab.LabResultTempKey;

public interface LabResultTempMapper {
    int deleteByPrimaryKey(LabResultTempKey key);

    int insert(LabResultTemp record);

    int insertSelective(LabResultTemp record);

    LabResultTemp selectByPrimaryKey(LabResultTempKey key);

    int updateByPrimaryKeySelective(LabResultTemp record);

    int updateByPrimaryKey(LabResultTemp record);
}