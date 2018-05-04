package com.ht.extra.dao;

import com.ht.extra.pojo.comm.InsuPhamDict;

public interface InsuPhamDictMapper {
    int deleteByPrimaryKey(Integer insuNo);

    int insert(InsuPhamDict record);

    int insertSelective(InsuPhamDict record);

    InsuPhamDict selectByPrimaryKey(Integer insuNo);

    int updateByPrimaryKeySelective(InsuPhamDict record);

    int updateByPrimaryKey(InsuPhamDict record);
}