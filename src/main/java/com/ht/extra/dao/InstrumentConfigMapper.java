package com.ht.extra.dao;

import com.ht.extra.pojo.lab.InstrumentConfig;
import com.ht.extra.pojo.lab.InstrumentConfigKey;

public interface InstrumentConfigMapper {
    int deleteByPrimaryKey(InstrumentConfigKey key);

    int insert(InstrumentConfig record);

    int insertSelective(InstrumentConfig record);

    InstrumentConfig selectByPrimaryKey(InstrumentConfigKey key);

    int updateByPrimaryKeySelective(InstrumentConfig record);

    int updateByPrimaryKey(InstrumentConfig record);
}