package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.NjjbReg2210;
import com.ht.extra.pojo.insurance.NjjbReg2210Key;

public interface NjjbReg2210Mapper {
    int deleteByPrimaryKey(NjjbReg2210Key key);

    int insert(NjjbReg2210 record);

    int insertSelective(NjjbReg2210 record);

    NjjbReg2210 selectByPrimaryKey(NjjbReg2210Key key);

    int updateByPrimaryKeySelective(NjjbReg2210 record);

    int updateByPrimaryKey(NjjbReg2210 record);
}