package com.ht.extra.dao;

import com.ht.extra.pojo.comm.QaEventTypeDict;

public interface QaEventTypeDictMapper {
    int deleteByPrimaryKey(String qaEventType);

    int insert(QaEventTypeDict record);

    int insertSelective(QaEventTypeDict record);

    QaEventTypeDict selectByPrimaryKey(String qaEventType);

    int updateByPrimaryKeySelective(QaEventTypeDict record);

    int updateByPrimaryKey(QaEventTypeDict record);
}