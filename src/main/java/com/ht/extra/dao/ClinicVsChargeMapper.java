package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ClinicVsCharge;
import com.ht.extra.pojo.comm.ClinicVsChargeKey;

import java.util.List;

public interface ClinicVsChargeMapper {
    int deleteByPrimaryKey(ClinicVsChargeKey key);

    int insert(ClinicVsCharge record);

    int insertSelective(ClinicVsCharge record);

    ClinicVsCharge selectByPrimaryKey(ClinicVsChargeKey key);

    int updateByPrimaryKeySelective(ClinicVsCharge record);

    int updateByPrimaryKey(ClinicVsCharge record);

    List<ClinicVsCharge> selectByAdministration(String administration);
}