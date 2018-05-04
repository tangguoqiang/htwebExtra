package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptOiAttrDict;

public interface DeptOiAttrDictMapper {
    int deleteByPrimaryKey(Short oiAttrCode);

    int insert(DeptOiAttrDict record);

    int insertSelective(DeptOiAttrDict record);

    DeptOiAttrDict selectByPrimaryKey(Short oiAttrCode);

    int updateByPrimaryKeySelective(DeptOiAttrDict record);

    int updateByPrimaryKey(DeptOiAttrDict record);
}