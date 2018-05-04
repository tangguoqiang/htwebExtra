package com.ht.extra.dao;

import com.ht.extra.pojo.comm.LabReportVsOrder;
import com.ht.extra.pojo.comm.LabReportVsOrderKey;

public interface LabReportVsOrderMapper {
    int deleteByPrimaryKey(LabReportVsOrderKey key);

    int insert(LabReportVsOrder record);

    int insertSelective(LabReportVsOrder record);

    LabReportVsOrder selectByPrimaryKey(LabReportVsOrderKey key);

    int updateByPrimaryKeySelective(LabReportVsOrder record);

    int updateByPrimaryKey(LabReportVsOrder record);
}