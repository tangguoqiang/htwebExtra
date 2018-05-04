package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.ClinicForRegist;
import com.ht.extra.pojo.outpadm.ClinicForRegistKey;

import java.util.List;

public interface ClinicForRegistMapper {
    int deleteByPrimaryKey(ClinicForRegistKey key);

    int insert(ClinicForRegist record);

    int insertSelective(ClinicForRegist record);

    ClinicForRegist selectByPrimaryKey(ClinicForRegistKey key);

    int updateByPrimaryKeySelective(ClinicForRegist record);

    int updateByPrimaryKey(ClinicForRegist record);

    List<ClinicForRegist> selectByClinicLabel(String clinicLabel, String time);

    List<ClinicForRegist> selectByDeptAndDocIdForRegist(String depId, String docId, String startDate, String endDate);

    List<ClinicForRegist> selectByDeptForRegist(String depId, String startDate, String endDate);

    List<ClinicForRegist> selectByDeptForRegistByTime(String startDate, String endDate);
}