package com.ht.extra.dao;

import com.ht.extra.pojo.comm.BillUnitsDict;

public interface BillUnitsDictMapper {
    int deleteByPrimaryKey(String billUnitsCode);

    int insert(BillUnitsDict record);

    int insertSelective(BillUnitsDict record);

    BillUnitsDict selectByPrimaryKey(String billUnitsCode);

    int updateByPrimaryKeySelective(BillUnitsDict record);

    int updateByPrimaryKey(BillUnitsDict record);
}