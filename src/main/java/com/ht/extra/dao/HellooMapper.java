package com.ht.extra.dao;

import com.ht.extra.pojo.comm.Helloo;

public interface HellooMapper {
    int insert(Helloo record);

    int insertSelective(Helloo record);
}