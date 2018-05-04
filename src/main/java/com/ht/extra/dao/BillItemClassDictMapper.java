package com.ht.extra.dao;

import com.ht.extra.pojo.comm.BillItemClassDict;

public interface BillItemClassDictMapper {
    int deleteByPrimaryKey(String classCode);

    int insert(BillItemClassDict record);

    int insertSelective(BillItemClassDict record);

    BillItemClassDict selectByPrimaryKey(String classCode);

    int updateByPrimaryKeySelective(BillItemClassDict record);

    int updateByPrimaryKey(BillItemClassDict record);
}