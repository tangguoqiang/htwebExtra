package com.ht.extra.dao;

import com.ht.extra.pojo.comm.InpRcptFeeDict;

public interface InpRcptFeeDictMapper {
    int deleteByPrimaryKey(String feeClassCode);

    int insert(InpRcptFeeDict record);

    int insertSelective(InpRcptFeeDict record);

    InpRcptFeeDict selectByPrimaryKey(String feeClassCode);

    int updateByPrimaryKeySelective(InpRcptFeeDict record);

    int updateByPrimaryKey(InpRcptFeeDict record);
}