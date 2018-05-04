package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.OutpAcctDetail;
import com.ht.extra.pojo.outpbill.OutpAcctDetailKey;

public interface OutpAcctDetailMapper {
    int deleteByPrimaryKey(OutpAcctDetailKey key);

    int insert(OutpAcctDetail record);

    int insertSelective(OutpAcctDetail record);

    OutpAcctDetail selectByPrimaryKey(OutpAcctDetailKey key);

    int updateByPrimaryKeySelective(OutpAcctDetail record);

    int updateByPrimaryKey(OutpAcctDetail record);
}