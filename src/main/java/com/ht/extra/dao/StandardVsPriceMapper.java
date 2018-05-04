package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StandardVsPrice;
import com.ht.extra.pojo.comm.StandardVsPriceKey;

public interface StandardVsPriceMapper {
    int deleteByPrimaryKey(StandardVsPriceKey key);

    int insert(StandardVsPrice record);

    int insertSelective(StandardVsPrice record);

    StandardVsPrice selectByPrimaryKey(StandardVsPriceKey key);

    int updateByPrimaryKeySelective(StandardVsPrice record);

    int updateByPrimaryKey(StandardVsPrice record);
}