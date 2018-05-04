package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.OutpWaitQueue;
import com.ht.extra.pojo.outpdoct.OutpWaitQueueKey;

public interface OutpWaitQueueMapper {
    int deleteByPrimaryKey(OutpWaitQueueKey key);

    int insert(OutpWaitQueue record);

    int insertSelective(OutpWaitQueue record);

    OutpWaitQueue selectByPrimaryKey(OutpWaitQueueKey key);

    int updateByPrimaryKeySelective(OutpWaitQueue record);

    int updateByPrimaryKey(OutpWaitQueue record);
}