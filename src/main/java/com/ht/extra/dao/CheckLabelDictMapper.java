package com.ht.extra.dao;

import com.ht.extra.pojo.comm.CheckLabelDict;

public interface CheckLabelDictMapper {
    int deleteByPrimaryKey(String checkLabelCode);

    int insert(CheckLabelDict record);

    int insertSelective(CheckLabelDict record);

    CheckLabelDict selectByPrimaryKey(String checkLabelCode);

    int updateByPrimaryKeySelective(CheckLabelDict record);

    int updateByPrimaryKey(CheckLabelDict record);
}