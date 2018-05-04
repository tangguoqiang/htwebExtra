package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.InpAcctDetail;
import com.ht.extra.pojo.inpbill.InpAcctDetailKey;

public interface InpAcctDetailMapper {
    int deleteByPrimaryKey(InpAcctDetailKey key);

    int insert(InpAcctDetail record);

    int insertSelective(InpAcctDetail record);

    InpAcctDetail selectByPrimaryKey(InpAcctDetailKey key);

    int updateByPrimaryKeySelective(InpAcctDetail record);

    int updateByPrimaryKey(InpAcctDetail record);
}