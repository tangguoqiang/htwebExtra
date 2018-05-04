package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.InpMrRec;

public interface InpMrRecMapper {
    int deleteByPrimaryKey(String patientId);

    int insert(InpMrRec record);

    int insertSelective(InpMrRec record);

    InpMrRec selectByPrimaryKey(String patientId);

    int updateByPrimaryKeySelective(InpMrRec record);

    int updateByPrimaryKey(InpMrRec record);
}