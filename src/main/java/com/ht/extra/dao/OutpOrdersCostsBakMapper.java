package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.OutpOrdersCostsBak;
import com.ht.extra.pojo.outpdoct.OutpOrdersCostsBakKey;

public interface OutpOrdersCostsBakMapper {
    int deleteByPrimaryKey(OutpOrdersCostsBakKey key);

    int insert(OutpOrdersCostsBak record);

    int insertSelective(OutpOrdersCostsBak record);

    OutpOrdersCostsBak selectByPrimaryKey(OutpOrdersCostsBakKey key);

    int updateByPrimaryKeySelective(OutpOrdersCostsBak record);

    int updateByPrimaryKey(OutpOrdersCostsBak record);
}