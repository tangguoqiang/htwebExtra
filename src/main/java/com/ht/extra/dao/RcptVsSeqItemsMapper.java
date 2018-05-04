package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.RcptVsSeqItems;

public interface RcptVsSeqItemsMapper {
    int deleteByPrimaryKey(String rcptNo);

    int insert(RcptVsSeqItems record);

    int insertSelective(RcptVsSeqItems record);

    RcptVsSeqItems selectByPrimaryKey(String rcptNo);

    int updateByPrimaryKeySelective(RcptVsSeqItems record);

    int updateByPrimaryKey(RcptVsSeqItems record);
}