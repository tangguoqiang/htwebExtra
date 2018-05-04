package com.ht.extra.dao;

import com.ht.extra.pojo.comm.LabListResultDict;
import com.ht.extra.pojo.comm.LabListResultDictKey;

public interface LabListResultDictMapper {
    int deleteByPrimaryKey(LabListResultDictKey key);

    int insert(LabListResultDict record);

    int insertSelective(LabListResultDict record);

    LabListResultDict selectByPrimaryKey(LabListResultDictKey key);

    int updateByPrimaryKeySelective(LabListResultDict record);

    int updateByPrimaryKey(LabListResultDict record);
}