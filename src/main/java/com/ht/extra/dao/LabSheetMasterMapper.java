package com.ht.extra.dao;

import com.ht.extra.pojo.comm.LabSheetMaster;

public interface LabSheetMasterMapper {
    int deleteByPrimaryKey(String labSheetId);

    int insert(LabSheetMaster record);

    int insertSelective(LabSheetMaster record);

    LabSheetMaster selectByPrimaryKey(String labSheetId);

    int updateByPrimaryKeySelective(LabSheetMaster record);

    int updateByPrimaryKey(LabSheetMaster record);
}