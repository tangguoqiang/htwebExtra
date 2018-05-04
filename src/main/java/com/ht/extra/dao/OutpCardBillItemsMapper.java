package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.OutpCardBillItems;
import com.ht.extra.pojo.outpbill.OutpCardBillItemsKey;

public interface OutpCardBillItemsMapper {
    int deleteByPrimaryKey(OutpCardBillItemsKey key);

    int insert(OutpCardBillItems record);

    int insertSelective(OutpCardBillItems record);

    OutpCardBillItems selectByPrimaryKey(OutpCardBillItemsKey key);

    int updateByPrimaryKeySelective(OutpCardBillItems record);

    int updateByPrimaryKey(OutpCardBillItems record);
}