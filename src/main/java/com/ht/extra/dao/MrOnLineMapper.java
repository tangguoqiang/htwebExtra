package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MrOnLine;
import com.ht.extra.pojo.medrec.MrOnLineKey;

public interface MrOnLineMapper {
    int deleteByPrimaryKey(MrOnLineKey key);

    int insert(MrOnLine record);

    int insertSelective(MrOnLine record);

    MrOnLine selectByPrimaryKey(MrOnLineKey key);

    int updateByPrimaryKeySelective(MrOnLine record);

    int updateByPrimaryKey(MrOnLine record);
}