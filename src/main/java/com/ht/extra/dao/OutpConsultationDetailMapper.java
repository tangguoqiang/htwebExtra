package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.OutpConsultationDetail;
import com.ht.extra.pojo.outpdoct.OutpConsultationDetailKey;

public interface OutpConsultationDetailMapper {
    int deleteByPrimaryKey(OutpConsultationDetailKey key);

    int insert(OutpConsultationDetail record);

    int insertSelective(OutpConsultationDetail record);

    OutpConsultationDetail selectByPrimaryKey(OutpConsultationDetailKey key);

    int updateByPrimaryKeySelective(OutpConsultationDetail record);

    int updateByPrimaryKey(OutpConsultationDetail record);
}