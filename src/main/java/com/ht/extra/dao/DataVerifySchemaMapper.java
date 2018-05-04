package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DataVerifySchema;

public interface DataVerifySchemaMapper {
    int deleteByPrimaryKey(String schemaCode);

    int insert(DataVerifySchema record);

    int insertSelective(DataVerifySchema record);

    DataVerifySchema selectByPrimaryKey(String schemaCode);

    int updateByPrimaryKeySelective(DataVerifySchema record);

    int updateByPrimaryKey(DataVerifySchema record);
}