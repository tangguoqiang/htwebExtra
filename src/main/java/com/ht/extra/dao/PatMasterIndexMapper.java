package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.PatMasterIndex;

public interface PatMasterIndexMapper {
    int deleteByPrimaryKey(String patientId);

    int insert(PatMasterIndex record);

    int insertSelective(PatMasterIndex record);

    PatMasterIndex selectByPrimaryKey(String patientId);

    int updateByPrimaryKeySelective(PatMasterIndex record);

    int updateByPrimaryKey(PatMasterIndex record);

    //没有增加军队医改的限制
    PatMasterIndex selectByPatientId(String patientId);

    PatMasterIndex selectByIdNo(String cardId);
}