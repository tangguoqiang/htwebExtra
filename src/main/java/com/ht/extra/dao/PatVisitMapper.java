package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.PatVisit;
import com.ht.extra.pojo.medrec.PatVisitKey;

import java.util.List;

public interface PatVisitMapper {
    int deleteByPrimaryKey(PatVisitKey key);

    int insert(PatVisit record);

    int insertSelective(PatVisit record);

    PatVisit selectByPrimaryKey(PatVisitKey key);

    int updateByPrimaryKeySelective(PatVisit record);

    int updateByPrimaryKey(PatVisit record);

    List<PatVisit> selectBytimes(String patientId);

    List<PatVisit> selectByOutDate(String startDate, String endDate);

    PatVisit selectByPatientId(String patientId);
}