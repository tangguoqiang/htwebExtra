package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.OutpPresc;
import com.ht.extra.pojo.outpdoct.OutpPrescKey;

public interface OutpPrescMapper {
    int deleteByPrimaryKey(OutpPrescKey key);

    int insert(OutpPresc record);

    int insertSelective(OutpPresc record);

    OutpPresc selectByPrimaryKey(OutpPrescKey key);

    int updateByPrimaryKeySelective(OutpPresc record);

    int updateByPrimaryKey(OutpPresc record);
}