package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.InvoiceInfo;
import com.ht.extra.pojo.outpbill.InvoiceInfoKey;

public interface InvoiceInfoMapper {
    int deleteByPrimaryKey(InvoiceInfoKey key);

    int insert(InvoiceInfo record);

    int insertSelective(InvoiceInfo record);

    InvoiceInfo selectByPrimaryKey(InvoiceInfoKey key);

    int updateByPrimaryKeySelective(InvoiceInfo record);

    int updateByPrimaryKey(InvoiceInfo record);
}