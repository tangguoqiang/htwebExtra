package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.OutpBillItemsBack;
import com.ht.extra.pojo.outpbill.OutpBillItemsBackKey;

public interface OutpBillItemsBackMapper {
    int deleteByPrimaryKey(OutpBillItemsBackKey key);

    int insert(OutpBillItemsBack record);

    int insertSelective(OutpBillItemsBack record);

    OutpBillItemsBack selectByPrimaryKey(OutpBillItemsBackKey key);

    int updateByPrimaryKeySelective(OutpBillItemsBack record);

    int updateByPrimaryKey(OutpBillItemsBack record);
}