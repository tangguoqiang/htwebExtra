package com.ht.extra.dao;

import com.ht.extra.pojo.comm.InputPatternDict;
import com.ht.extra.pojo.comm.InputPatternDictKey;

public interface InputPatternDictMapper {
    int deleteByPrimaryKey(InputPatternDictKey key);

    int insert(InputPatternDict record);

    int insertSelective(InputPatternDict record);

    InputPatternDict selectByPrimaryKey(InputPatternDictKey key);

    int updateByPrimaryKeySelective(InputPatternDict record);

    int updateByPrimaryKey(InputPatternDict record);
}