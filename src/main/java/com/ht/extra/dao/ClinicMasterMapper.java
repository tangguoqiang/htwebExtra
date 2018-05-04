package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.ClinicMaster;
import com.ht.extra.pojo.outpadm.ClinicMasterKey;

import java.util.Date;
import java.util.List;

public interface ClinicMasterMapper {
    int deleteByPrimaryKey(ClinicMasterKey key);

    int insert(ClinicMaster record);

    int insertSelective(ClinicMaster record);

    ClinicMaster selectByPrimaryKey(ClinicMasterKey key);

    int updateByPrimaryKeySelective(ClinicMaster record);

    int updateByPrimaryKey(ClinicMaster record);

    ClinicMaster selectByVisitDate(Date visitDate);

    List<ClinicMaster> selectByVisitDateAll(String startDate, String endDate);

    List<ClinicMaster> selectByClinicLabel(String time, String patientId, String clinicLabel, String seeTime);

    List<ClinicMaster> selectRegesters(Date clinicDate, String clinicLabel);
}