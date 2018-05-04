package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MrIndex;
import com.ht.extra.pojo.medrec.MrIndexKey;

public interface MrIndexMapper {
    int deleteByPrimaryKey(MrIndexKey key);

    int insert(MrIndex record);

    int insertSelective(MrIndex record);

    MrIndex selectByPrimaryKey(MrIndexKey key);

    int updateByPrimaryKeySelective(MrIndex record);

    int updateByPrimaryKey(MrIndex record);
}