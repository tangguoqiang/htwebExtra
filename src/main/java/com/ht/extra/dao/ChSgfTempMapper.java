package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.ChSgfTemp;
import com.ht.extra.pojo.inpbill.ChSgfTempKey;

public interface ChSgfTempMapper {
    int deleteByPrimaryKey(ChSgfTempKey key);

    int insert(ChSgfTemp record);

    int insertSelective(ChSgfTemp record);

    ChSgfTemp selectByPrimaryKey(ChSgfTempKey key);

    int updateByPrimaryKeySelective(ChSgfTemp record);

    int updateByPrimaryKey(ChSgfTemp record);
}