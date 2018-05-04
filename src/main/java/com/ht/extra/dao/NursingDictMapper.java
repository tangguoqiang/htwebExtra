package com.ht.extra.dao;

import com.ht.extra.pojo.comm.NursingDict;

public interface NursingDictMapper {
    int insert(NursingDict record);

    int insertSelective(NursingDict record);
}