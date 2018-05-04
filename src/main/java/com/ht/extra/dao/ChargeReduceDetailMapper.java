package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.ChargeReduceDetail;
import com.ht.extra.pojo.outpbill.ChargeReduceDetailKey;

public interface ChargeReduceDetailMapper {
    int deleteByPrimaryKey(ChargeReduceDetailKey key);

    int insert(ChargeReduceDetail record);

    int insertSelective(ChargeReduceDetail record);

    ChargeReduceDetail selectByPrimaryKey(ChargeReduceDetailKey key);

    int updateByPrimaryKeySelective(ChargeReduceDetail record);

    int updateByPrimaryKey(ChargeReduceDetail record);
}