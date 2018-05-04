package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.BillMiscItem;
import com.ht.extra.pojo.inpbill.BillMiscItemKey;

public interface BillMiscItemMapper {
    int deleteByPrimaryKey(BillMiscItemKey key);

    int insert(BillMiscItem record);

    int insertSelective(BillMiscItem record);

    BillMiscItem selectByPrimaryKey(BillMiscItemKey key);

    int updateByPrimaryKeySelective(BillMiscItem record);

    int updateByPrimaryKey(BillMiscItem record);
}