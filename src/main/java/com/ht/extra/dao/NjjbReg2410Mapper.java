package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.NjjbReg2410;
import com.ht.extra.pojo.insurance.NjjbReg2410Key;

public interface NjjbReg2410Mapper {
    int deleteByPrimaryKey(NjjbReg2410Key key);

    int insert(NjjbReg2410 record);

    int insertSelective(NjjbReg2410 record);

    NjjbReg2410 selectByPrimaryKey(NjjbReg2410Key key);

    int updateByPrimaryKeySelective(NjjbReg2410 record);

    int updateByPrimaryKey(NjjbReg2410 record);
}