package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.PrepaymentRcpt;

import java.util.List;

public interface PrepaymentRcptMapper {
    int deleteByPrimaryKey(String rcptNo);

    int insert(PrepaymentRcpt record);

    int insertSelective(PrepaymentRcpt record);

    PrepaymentRcpt selectByPrimaryKey(String rcptNo);

    int updateByPrimaryKeySelective(PrepaymentRcpt record);

    int updateByPrimaryKey(PrepaymentRcpt record);

    List<PrepaymentRcpt> selectByPatientVisit(String patientId, short visitId);
}