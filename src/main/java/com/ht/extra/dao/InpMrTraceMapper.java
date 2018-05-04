package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.InpMrTrace;
import com.ht.extra.pojo.medrec.InpMrTraceKey;

public interface InpMrTraceMapper {
    int deleteByPrimaryKey(InpMrTraceKey key);

    int insert(InpMrTrace record);

    int insertSelective(InpMrTrace record);

    InpMrTrace selectByPrimaryKey(InpMrTraceKey key);

    int updateByPrimaryKeySelective(InpMrTrace record);

    int updateByPrimaryKey(InpMrTrace record);
}