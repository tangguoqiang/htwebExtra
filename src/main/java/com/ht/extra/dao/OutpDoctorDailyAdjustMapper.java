package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.OutpDoctorDailyAdjustKey;

public interface OutpDoctorDailyAdjustMapper {
    int deleteByPrimaryKey(OutpDoctorDailyAdjustKey key);

    int insert(OutpDoctorDailyAdjustKey record);

    int insertSelective(OutpDoctorDailyAdjustKey record);
}