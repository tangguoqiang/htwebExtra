package com.ht.extra.dao;

import com.ht.extra.pojo.comm.Metadict;

public interface MetadictMapper {
    int deleteByPrimaryKey(String tableName);

    int insert(Metadict record);

    int insertSelective(Metadict record);

    Metadict selectByPrimaryKey(String tableName);

    int updateByPrimaryKeySelective(Metadict record);

    int updateByPrimaryKey(Metadict record);
}