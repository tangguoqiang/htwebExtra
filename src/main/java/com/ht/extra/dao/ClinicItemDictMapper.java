package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ClinicItemDict;
import com.ht.extra.pojo.comm.ClinicItemDictKey;

public interface ClinicItemDictMapper {
    int deleteByPrimaryKey(ClinicItemDictKey key);

    int insert(ClinicItemDict record);

    int insertSelective(ClinicItemDict record);

    ClinicItemDict selectByPrimaryKey(ClinicItemDictKey key);

    int updateByPrimaryKeySelective(ClinicItemDict record);

    int updateByPrimaryKey(ClinicItemDict record);
}