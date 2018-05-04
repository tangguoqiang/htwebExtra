package com.ht.extra.dao;

import com.ht.extra.pojo.comm.LabOrderVsReport;

public interface LabOrderVsReportMapper {
    int deleteByPrimaryKey(Short serialNo);

    int insert(LabOrderVsReport record);

    int insertSelective(LabOrderVsReport record);

    LabOrderVsReport selectByPrimaryKey(Short serialNo);

    int updateByPrimaryKeySelective(LabOrderVsReport record);

    int updateByPrimaryKey(LabOrderVsReport record);
}