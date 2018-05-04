package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OutpRcptFeeDict;

public interface OutpRcptFeeDictMapper {
    int deleteByPrimaryKey(String feeClassCode);

    int insert(OutpRcptFeeDict record);

    int insertSelective(OutpRcptFeeDict record);

    OutpRcptFeeDict selectByPrimaryKey(String feeClassCode);

    int updateByPrimaryKeySelective(OutpRcptFeeDict record);

    int updateByPrimaryKey(OutpRcptFeeDict record);
}