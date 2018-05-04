package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.OutpMrTrace;
import com.ht.extra.pojo.medrec.OutpMrTraceKey;

public interface OutpMrTraceMapper {
    int deleteByPrimaryKey(OutpMrTraceKey key);

    int insert(OutpMrTrace record);

    int insertSelective(OutpMrTrace record);

    OutpMrTrace selectByPrimaryKey(OutpMrTraceKey key);

    int updateByPrimaryKeySelective(OutpMrTrace record);

    int updateByPrimaryKey(OutpMrTrace record);
}