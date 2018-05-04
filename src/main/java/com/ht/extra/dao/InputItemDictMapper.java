package com.ht.extra.dao;

import com.ht.extra.pojo.comm.InputItemDict;
import com.ht.extra.pojo.comm.InputItemDictKey;

public interface InputItemDictMapper {
    int deleteByPrimaryKey(InputItemDictKey key);

    int insert(InputItemDict record);

    int insertSelective(InputItemDict record);

    InputItemDict selectByPrimaryKey(InputItemDictKey key);

    int updateByPrimaryKeySelective(InputItemDict record);

    int updateByPrimaryKey(InputItemDict record);
}