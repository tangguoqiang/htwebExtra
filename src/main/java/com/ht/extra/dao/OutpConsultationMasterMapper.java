package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.OutpConsultationMaster;
import com.ht.extra.pojo.outpdoct.OutpConsultationMasterKey;

public interface OutpConsultationMasterMapper {
    int deleteByPrimaryKey(OutpConsultationMasterKey key);

    int insert(OutpConsultationMaster record);

    int insertSelective(OutpConsultationMaster record);

    OutpConsultationMaster selectByPrimaryKey(OutpConsultationMasterKey key);

    int updateByPrimaryKeySelective(OutpConsultationMaster record);

    int updateByPrimaryKey(OutpConsultationMaster record);
}