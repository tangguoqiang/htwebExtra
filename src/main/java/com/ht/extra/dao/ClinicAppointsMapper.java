package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.ClinicAppoints;
import com.ht.extra.pojo.outpadm.ClinicAppointsKey;

import java.util.Date;
import java.util.List;

public interface ClinicAppointsMapper {
    int deleteByPrimaryKey(ClinicAppointsKey key);

    int insert(ClinicAppoints record);

    int insertSelective(ClinicAppoints record);

    ClinicAppoints selectByPrimaryKey(ClinicAppointsKey key);

    int updateByPrimaryKeySelective(ClinicAppoints record);

    int updateByPrimaryKey(ClinicAppoints record);

    List<ClinicAppoints>  selectByPatientId(String patientId);

    List<ClinicAppoints> selectApponints(Date visitDateAppted, String clinicLabel);

    List<ClinicAppoints> selectRegesters(Date clinicDate, String clinicLabel);
}