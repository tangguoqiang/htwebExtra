package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.ClinicSchedule;
import com.ht.extra.pojo.outpadm.ClinicScheduleKey;

import java.util.List;

public interface ClinicScheduleMapper {
    int deleteByPrimaryKey(ClinicScheduleKey key);

    int insert(ClinicSchedule record);

    int insertSelective(ClinicSchedule record);

    ClinicSchedule selectByPrimaryKey(ClinicScheduleKey key);

    int updateByPrimaryKeySelective(ClinicSchedule record);

    int updateByPrimaryKey(ClinicSchedule record);

    List<ClinicSchedule> selectByDeptForSchedule(String clinicdept);

    List<ClinicSchedule> selectByDeptAndDocIdForSchedule(String clinicdept, String docId);

    List<ClinicSchedule> selectForSchedule();
}