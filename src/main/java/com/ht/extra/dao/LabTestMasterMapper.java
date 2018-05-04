package com.ht.extra.dao;

import com.ht.extra.pojo.lab.LabTestMaster;

import java.util.List;

public interface LabTestMasterMapper {
    int deleteByPrimaryKey(String testNo);

    int insert(LabTestMaster record);

    int insertSelective(LabTestMaster record);

    LabTestMaster selectByPrimaryKey(String testNo);

    int updateByPrimaryKeySelective(LabTestMaster record);

    int updateByPrimaryKey(LabTestMaster record);

    List<LabTestMaster> selectByPatient(String patientId);


}