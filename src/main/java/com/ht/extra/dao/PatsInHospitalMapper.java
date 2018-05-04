package com.ht.extra.dao;

import com.ht.extra.pojo.inpadm.PatsInHospital;

import java.util.List;

public interface PatsInHospitalMapper {
    int deleteByPrimaryKey(String patientId);

    int insert(PatsInHospital record);

    int insertSelective(PatsInHospital record);

    PatsInHospital selectByPrimaryKey(String patientId);

    int updateByPrimaryKeySelective(PatsInHospital record);

    int updateByPrimaryKey(PatsInHospital record);

    List<PatsInHospital> selectByOutTime(String patientId, String date1, String date2);
}