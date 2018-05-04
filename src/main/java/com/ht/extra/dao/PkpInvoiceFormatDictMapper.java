package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PkpInvoiceFormatDict;
import com.ht.extra.pojo.comm.PkpInvoiceFormatDictKey;

public interface PkpInvoiceFormatDictMapper {
    int deleteByPrimaryKey(PkpInvoiceFormatDictKey key);

    int insert(PkpInvoiceFormatDict record);

    int insertSelective(PkpInvoiceFormatDict record);

    PkpInvoiceFormatDict selectByPrimaryKey(PkpInvoiceFormatDictKey key);

    int updateByPrimaryKeySelective(PkpInvoiceFormatDict record);

    int updateByPrimaryKey(PkpInvoiceFormatDict record);
}