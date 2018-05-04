package com.ht.extra.dao;

import com.ht.extra.pojo.comm.HelpMsg;
import com.ht.extra.pojo.comm.HelpMsgKey;

public interface HelpMsgMapper {
    int deleteByPrimaryKey(HelpMsgKey key);

    int insert(HelpMsg record);

    int insertSelective(HelpMsg record);

    HelpMsg selectByPrimaryKey(HelpMsgKey key);

    int updateByPrimaryKeySelective(HelpMsg record);

    int updateByPrimaryKeyWithBLOBs(HelpMsg record);
}