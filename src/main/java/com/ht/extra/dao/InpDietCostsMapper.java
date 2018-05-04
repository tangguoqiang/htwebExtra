package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.InpDietCosts;
import com.ht.extra.pojo.inpbill.InpDietCostsKey;

public interface InpDietCostsMapper {
    int deleteByPrimaryKey(InpDietCostsKey key);

    int insert(InpDietCosts record);

    int insertSelective(InpDietCosts record);

    InpDietCosts selectByPrimaryKey(InpDietCostsKey key);

    int updateByPrimaryKeySelective(InpDietCosts record);

    int updateByPrimaryKey(InpDietCosts record);
}