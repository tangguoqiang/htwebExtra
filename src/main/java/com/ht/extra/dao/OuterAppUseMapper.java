package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OuterAppUseKey;

public interface OuterAppUseMapper {
    int deleteByPrimaryKey(OuterAppUseKey key);

    int insert(OuterAppUseKey record);

    int insertSelective(OuterAppUseKey record);
}