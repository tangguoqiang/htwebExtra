package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OuterCodeDict;
import com.ht.extra.pojo.comm.OuterCodeDictKey;

public interface OuterCodeDictMapper {
    int deleteByPrimaryKey(OuterCodeDictKey key);

    int insert(OuterCodeDict record);

    int insertSelective(OuterCodeDict record);

    OuterCodeDict selectByPrimaryKey(OuterCodeDictKey key);

    int updateByPrimaryKeySelective(OuterCodeDict record);

    int updateByPrimaryKey(OuterCodeDict record);
}