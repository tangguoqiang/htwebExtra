package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.NjjbReg2420;
import com.ht.extra.pojo.insurance.NjjbReg2420Key;

public interface NjjbReg2420Mapper {
    int deleteByPrimaryKey(NjjbReg2420Key key);

    int insert(NjjbReg2420 record);

    int insertSelective(NjjbReg2420 record);

    NjjbReg2420 selectByPrimaryKey(NjjbReg2420Key key);

    int updateByPrimaryKeySelective(NjjbReg2420 record);

    int updateByPrimaryKey(NjjbReg2420 record);
}