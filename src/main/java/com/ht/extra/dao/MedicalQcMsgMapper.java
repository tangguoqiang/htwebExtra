package com.ht.extra.dao;

import com.ht.extra.pojo.inpadm.MedicalQcMsg;
import com.ht.extra.pojo.inpadm.MedicalQcMsgKey;

public interface MedicalQcMsgMapper {
    int deleteByPrimaryKey(MedicalQcMsgKey key);

    int insert(MedicalQcMsg record);

    int insertSelective(MedicalQcMsg record);

    MedicalQcMsg selectByPrimaryKey(MedicalQcMsgKey key);

    int updateByPrimaryKeySelective(MedicalQcMsg record);

    int updateByPrimaryKey(MedicalQcMsg record);
}