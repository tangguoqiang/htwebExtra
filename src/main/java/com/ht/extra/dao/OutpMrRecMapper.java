package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.OutpMrRec;

public interface OutpMrRecMapper {
    int deleteByPrimaryKey(String patientId);

    int insert(OutpMrRec record);

    int insertSelective(OutpMrRec record);

    OutpMrRec selectByPrimaryKey(String patientId);

    int updateByPrimaryKeySelective(OutpMrRec record);

    int updateByPrimaryKey(OutpMrRec record);
}