package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.OutpOrderDesc;
import com.ht.extra.pojo.outpbill.OutpOrderDescKey;

public interface OutpOrderDescMapper {
    int deleteByPrimaryKey(OutpOrderDescKey key);

    int insert(OutpOrderDesc record);

    int insertSelective(OutpOrderDesc record);

    OutpOrderDesc selectByPrimaryKey(OutpOrderDescKey key);

    int updateByPrimaryKeySelective(OutpOrderDesc record);

    int updateByPrimaryKey(OutpOrderDesc record);
}