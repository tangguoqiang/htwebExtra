package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.OutpCounselQueue;
import com.ht.extra.pojo.outpadm.OutpCounselQueueKey;

public interface OutpCounselQueueMapper {
    int deleteByPrimaryKey(OutpCounselQueueKey key);

    int insert(OutpCounselQueue record);

    int insertSelective(OutpCounselQueue record);

    OutpCounselQueue selectByPrimaryKey(OutpCounselQueueKey key);

    int updateByPrimaryKeySelective(OutpCounselQueue record);

    int updateByPrimaryKey(OutpCounselQueue record);
}