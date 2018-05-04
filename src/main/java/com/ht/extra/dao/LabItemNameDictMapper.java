package com.ht.extra.dao;

import com.ht.extra.pojo.comm.LabItemNameDict;

public interface LabItemNameDictMapper {
    int insert(LabItemNameDict record);

    int insertSelective(LabItemNameDict record);
}