package com.ht.extra.dao;

import com.ht.extra.pojo.comm.LabItemDict;

public interface LabItemDictMapper {
    int insert(LabItemDict record);

    int insertSelective(LabItemDict record);
}