package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MrTraceLog;
import com.ht.extra.pojo.medrec.MrTraceLogKey;

public interface MrTraceLogMapper {
    int deleteByPrimaryKey(MrTraceLogKey key);

    int insert(MrTraceLog record);

    int insertSelective(MrTraceLog record);

    MrTraceLog selectByPrimaryKey(MrTraceLogKey key);

    int updateByPrimaryKeySelective(MrTraceLog record);

    int updateByPrimaryKey(MrTraceLog record);
}