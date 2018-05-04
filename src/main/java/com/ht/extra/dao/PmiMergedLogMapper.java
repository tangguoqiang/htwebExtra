package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.PmiMergedLog;
import com.ht.extra.pojo.medrec.PmiMergedLogKey;

public interface PmiMergedLogMapper {
    int deleteByPrimaryKey(PmiMergedLogKey key);

    int insert(PmiMergedLog record);

    int insertSelective(PmiMergedLog record);

    PmiMergedLog selectByPrimaryKey(PmiMergedLogKey key);

    int updateByPrimaryKeySelective(PmiMergedLog record);

    int updateByPrimaryKey(PmiMergedLog record);
}