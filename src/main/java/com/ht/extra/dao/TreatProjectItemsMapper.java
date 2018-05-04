package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.TreatProjectItems;
import com.ht.extra.pojo.outpdoct.TreatProjectItemsKey;

public interface TreatProjectItemsMapper {
    int deleteByPrimaryKey(TreatProjectItemsKey key);

    int insert(TreatProjectItems record);

    int insertSelective(TreatProjectItems record);

    TreatProjectItems selectByPrimaryKey(TreatProjectItemsKey key);

    int updateByPrimaryKeySelective(TreatProjectItems record);

    int updateByPrimaryKey(TreatProjectItems record);
}