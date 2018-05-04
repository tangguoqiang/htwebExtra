package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.OutpDoctorSchedule;
import com.ht.extra.pojo.outpadm.OutpDoctorScheduleKey;

public interface OutpDoctorScheduleMapper {
    int deleteByPrimaryKey(OutpDoctorScheduleKey key);

    int insert(OutpDoctorSchedule record);

    int insertSelective(OutpDoctorSchedule record);

    OutpDoctorSchedule selectByPrimaryKey(OutpDoctorScheduleKey key);

    int updateByPrimaryKeySelective(OutpDoctorSchedule record);

    int updateByPrimaryKey(OutpDoctorSchedule record);
}