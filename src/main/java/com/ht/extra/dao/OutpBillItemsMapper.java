package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.OutpBillItems;
import com.ht.extra.pojo.outpbill.OutpBillItemsKey;

public interface OutpBillItemsMapper {
    int deleteByPrimaryKey(OutpBillItemsKey key);

    int insert(OutpBillItems record);

    int insertSelective(OutpBillItems record);

    OutpBillItems selectByPrimaryKey(OutpBillItemsKey key);

    int updateByPrimaryKeySelective(OutpBillItems record);

    int updateByPrimaryKey(OutpBillItems record);
}