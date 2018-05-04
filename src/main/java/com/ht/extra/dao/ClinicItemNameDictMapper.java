package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ClinicItemNameDict;
import com.ht.extra.pojo.comm.ClinicItemNameDictKey;

public interface ClinicItemNameDictMapper {
    int deleteByPrimaryKey(ClinicItemNameDictKey key);

    int insert(ClinicItemNameDict record);

    int insertSelective(ClinicItemNameDict record);

    ClinicItemNameDict selectByPrimaryKey(ClinicItemNameDictKey key);

    int updateByPrimaryKeySelective(ClinicItemNameDict record);

    int updateByPrimaryKey(ClinicItemNameDict record);
}