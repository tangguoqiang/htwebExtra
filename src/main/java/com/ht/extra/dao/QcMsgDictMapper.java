package com.ht.extra.dao;

import com.ht.extra.pojo.comm.QcMsgDict;

public interface QcMsgDictMapper {
    int deleteByPrimaryKey(String qcMsgCode);

    int insert(QcMsgDict record);

    int insertSelective(QcMsgDict record);

    QcMsgDict selectByPrimaryKey(String qcMsgCode);

    int updateByPrimaryKeySelective(QcMsgDict record);

    int updateByPrimaryKey(QcMsgDict record);
}