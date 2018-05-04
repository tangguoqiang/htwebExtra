package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.CasherNoRec;

public interface CasherNoRecMapper {
    int deleteByPrimaryKey(String localNo);

    int insert(CasherNoRec record);

    int insertSelective(CasherNoRec record);

    CasherNoRec selectByPrimaryKey(String localNo);

    int updateByPrimaryKeySelective(CasherNoRec record);

    int updateByPrimaryKey(CasherNoRec record);
}