package com.ht.extra.dao;

import com.ht.extra.pojo.comm.TreatItemDict;

public interface TreatItemDictMapper {
    int insert(TreatItemDict record);

    int insertSelective(TreatItemDict record);
}