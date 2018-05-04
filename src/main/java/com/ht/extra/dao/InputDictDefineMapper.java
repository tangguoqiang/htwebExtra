package com.ht.extra.dao;

import com.ht.extra.pojo.comm.InputDictDefine;
import com.ht.extra.pojo.comm.InputDictDefineKey;

public interface InputDictDefineMapper {
    int deleteByPrimaryKey(InputDictDefineKey key);

    int insert(InputDictDefine record);

    int insertSelective(InputDictDefine record);

    InputDictDefine selectByPrimaryKey(InputDictDefineKey key);

    int updateByPrimaryKeySelective(InputDictDefine record);

    int updateByPrimaryKey(InputDictDefine record);
}