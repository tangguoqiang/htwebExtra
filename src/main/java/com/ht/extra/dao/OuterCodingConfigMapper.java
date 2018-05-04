package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OuterCodingConfig;
import com.ht.extra.pojo.comm.OuterCodingConfigKey;

public interface OuterCodingConfigMapper {
    int deleteByPrimaryKey(OuterCodingConfigKey key);

    int insert(OuterCodingConfig record);

    int insertSelective(OuterCodingConfig record);

    OuterCodingConfig selectByPrimaryKey(OuterCodingConfigKey key);

    int updateByPrimaryKeySelective(OuterCodingConfig record);

    int updateByPrimaryKey(OuterCodingConfig record);
}