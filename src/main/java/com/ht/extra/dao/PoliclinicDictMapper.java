package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PoliclinicDict;

public interface PoliclinicDictMapper {
    int deleteByPrimaryKey(String policlinicCode);

    int insert(PoliclinicDict record);

    int insertSelective(PoliclinicDict record);

    PoliclinicDict selectByPrimaryKey(String policlinicCode);

    int updateByPrimaryKeySelective(PoliclinicDict record);

    int updateByPrimaryKey(PoliclinicDict record);
}