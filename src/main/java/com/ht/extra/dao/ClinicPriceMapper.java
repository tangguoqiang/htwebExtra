package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.ClinicPrice;

public interface ClinicPriceMapper {
    int deleteByPrimaryKey(String chargeType);

    int insert(ClinicPrice record);

    int insertSelective(ClinicPrice record);

    ClinicPrice selectByPrimaryKey(String chargeType);

    int updateByPrimaryKeySelective(ClinicPrice record);

    int updateByPrimaryKey(ClinicPrice record);
}