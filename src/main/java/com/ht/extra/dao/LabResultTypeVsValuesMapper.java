package com.ht.extra.dao;

import com.ht.extra.pojo.lab.LabResultTypeVsValues;

public interface LabResultTypeVsValuesMapper {
    int deleteByPrimaryKey(Short serialNo);

    int insert(LabResultTypeVsValues record);

    int insertSelective(LabResultTypeVsValues record);

    LabResultTypeVsValues selectByPrimaryKey(Short serialNo);

    int updateByPrimaryKeySelective(LabResultTypeVsValues record);

    int updateByPrimaryKey(LabResultTypeVsValues record);
}