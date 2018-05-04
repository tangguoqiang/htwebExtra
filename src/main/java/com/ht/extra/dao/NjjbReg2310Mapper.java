package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.NjjbReg2310;
import com.ht.extra.pojo.insurance.NjjbReg2310Key;

public interface NjjbReg2310Mapper {
    int deleteByPrimaryKey(NjjbReg2310Key key);

    int insert(NjjbReg2310 record);

    int insertSelective(NjjbReg2310 record);

    NjjbReg2310 selectByPrimaryKey(NjjbReg2310Key key);

    int updateByPrimaryKeySelective(NjjbReg2310 record);

    int updateByPrimaryKey(NjjbReg2310 record);
}