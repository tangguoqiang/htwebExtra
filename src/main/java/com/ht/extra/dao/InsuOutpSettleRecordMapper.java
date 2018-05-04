package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuOutpSettleRecord;

public interface InsuOutpSettleRecordMapper {
    int deleteByPrimaryKey(String insuRcptNo);

    int insert(InsuOutpSettleRecord record);

    int insertSelective(InsuOutpSettleRecord record);

    InsuOutpSettleRecord selectByPrimaryKey(String insuRcptNo);

    int updateByPrimaryKeySelective(InsuOutpSettleRecord record);

    int updateByPrimaryKey(InsuOutpSettleRecord record);
}