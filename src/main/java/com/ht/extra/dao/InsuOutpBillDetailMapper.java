package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuOutpBillDetail;
import com.ht.extra.pojo.insurance.InsuOutpBillDetailKey;

public interface InsuOutpBillDetailMapper {
    int deleteByPrimaryKey(InsuOutpBillDetailKey key);

    int insert(InsuOutpBillDetail record);

    int insertSelective(InsuOutpBillDetail record);

    InsuOutpBillDetail selectByPrimaryKey(InsuOutpBillDetailKey key);

    int updateByPrimaryKeySelective(InsuOutpBillDetail record);

    int updateByPrimaryKey(InsuOutpBillDetail record);
}