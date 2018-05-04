package com.ht.extra.dao;

import com.ht.extra.pojo.comm.HospdiagVsCenterdiag;
import com.ht.extra.pojo.comm.HospdiagVsCenterdiagKey;

public interface HospdiagVsCenterdiagMapper {
    int deleteByPrimaryKey(HospdiagVsCenterdiagKey key);

    int insert(HospdiagVsCenterdiag record);

    int insertSelective(HospdiagVsCenterdiag record);

    HospdiagVsCenterdiag selectByPrimaryKey(HospdiagVsCenterdiagKey key);

    int updateByPrimaryKeySelective(HospdiagVsCenterdiag record);

    int updateByPrimaryKey(HospdiagVsCenterdiag record);
}