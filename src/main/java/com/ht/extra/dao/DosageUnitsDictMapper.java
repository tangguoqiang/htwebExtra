package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DosageUnitsDict;

public interface DosageUnitsDictMapper {
    int deleteByPrimaryKey(String dosageUnits);

    int insert(DosageUnitsDict record);

    int insertSelective(DosageUnitsDict record);

    DosageUnitsDict selectByPrimaryKey(String dosageUnits);

    int updateByPrimaryKeySelective(DosageUnitsDict record);

    int updateByPrimaryKey(DosageUnitsDict record);
}