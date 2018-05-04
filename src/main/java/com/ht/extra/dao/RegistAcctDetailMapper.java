package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.RegistAcctDetail;
import com.ht.extra.pojo.outpadm.RegistAcctDetailKey;

public interface RegistAcctDetailMapper {
    int deleteByPrimaryKey(RegistAcctDetailKey key);

    int insert(RegistAcctDetail record);

    int insertSelective(RegistAcctDetail record);

    RegistAcctDetail selectByPrimaryKey(RegistAcctDetailKey key);

    int updateByPrimaryKeySelective(RegistAcctDetail record);

    int updateByPrimaryKey(RegistAcctDetail record);
}