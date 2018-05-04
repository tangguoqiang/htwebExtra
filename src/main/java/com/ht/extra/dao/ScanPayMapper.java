package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.ScanPay;
import java.math.BigDecimal;

public interface ScanPayMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(ScanPay record);

    int insertSelective(ScanPay record);

    ScanPay selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(ScanPay record);

    int updateByPrimaryKey(ScanPay record);
}