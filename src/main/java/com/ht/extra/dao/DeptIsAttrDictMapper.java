package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptIsAttrDict;

public interface DeptIsAttrDictMapper {
    int deleteByPrimaryKey(Short isAttrCode);

    int insert(DeptIsAttrDict record);

    int insertSelective(DeptIsAttrDict record);

    DeptIsAttrDict selectByPrimaryKey(Short isAttrCode);

    int updateByPrimaryKeySelective(DeptIsAttrDict record);

    int updateByPrimaryKey(DeptIsAttrDict record);
}