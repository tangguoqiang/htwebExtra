package com.ht.extra.dao;

import com.ht.extra.pojo.comm.LabReportItemDict;

public interface LabReportItemDictMapper {
    int deleteByPrimaryKey(String itemCode);

    int insert(LabReportItemDict record);

    int insertSelective(LabReportItemDict record);

    LabReportItemDict selectByPrimaryKey(String itemCode);

    int updateByPrimaryKeySelective(LabReportItemDict record);

    int updateByPrimaryKey(LabReportItemDict record);
}