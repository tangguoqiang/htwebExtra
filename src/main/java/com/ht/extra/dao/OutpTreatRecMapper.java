package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.OutpTreatRec;
import com.ht.extra.pojo.outpdoct.OutpTreatRecKey;

public interface OutpTreatRecMapper {
    int deleteByPrimaryKey(OutpTreatRecKey key);

    int insert(OutpTreatRec record);

    int insertSelective(OutpTreatRec record);

    OutpTreatRec selectByPrimaryKey(OutpTreatRecKey key);

    int updateByPrimaryKeySelective(OutpTreatRec record);

    int updateByPrimaryKey(OutpTreatRec record);
}