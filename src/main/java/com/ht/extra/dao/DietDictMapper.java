package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DietDict;

public interface DietDictMapper {
    int insert(DietDict record);

    int insertSelective(DietDict record);
}