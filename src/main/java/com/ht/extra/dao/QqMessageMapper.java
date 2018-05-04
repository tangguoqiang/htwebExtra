package com.ht.extra.dao;

import com.ht.extra.pojo.comm.QqMessage;
import com.ht.extra.pojo.comm.QqMessageKey;

public interface QqMessageMapper {
    int deleteByPrimaryKey(QqMessageKey key);

    int insert(QqMessage record);

    int insertSelective(QqMessage record);

    QqMessage selectByPrimaryKey(QqMessageKey key);

    int updateByPrimaryKeySelective(QqMessage record);

    int updateByPrimaryKey(QqMessage record);
}