package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DataVerifyResult;
import com.ht.extra.pojo.comm.DataVerifyResultKey;

public interface DataVerifyResultMapper {
    int deleteByPrimaryKey(DataVerifyResultKey key);

    int insert(DataVerifyResult record);

    int insertSelective(DataVerifyResult record);

    DataVerifyResult selectByPrimaryKey(DataVerifyResultKey key);

    int updateByPrimaryKeySelective(DataVerifyResult record);

    int updateByPrimaryKey(DataVerifyResult record);
}