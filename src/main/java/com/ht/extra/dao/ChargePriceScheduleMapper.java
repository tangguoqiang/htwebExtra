package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ChargePriceSchedule;

public interface ChargePriceScheduleMapper {
    int deleteByPrimaryKey(String chargeType);

    int insert(ChargePriceSchedule record);

    int insertSelective(ChargePriceSchedule record);

    ChargePriceSchedule selectByPrimaryKey(String chargeType);

    int updateByPrimaryKeySelective(ChargePriceSchedule record);

    int updateByPrimaryKey(ChargePriceSchedule record);
}