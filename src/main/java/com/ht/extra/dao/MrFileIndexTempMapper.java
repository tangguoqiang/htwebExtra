package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MrFileIndexTemp;
import com.ht.extra.pojo.medrec.MrFileIndexTempKey;

public interface MrFileIndexTempMapper {
    int deleteByPrimaryKey(MrFileIndexTempKey key);

    int insert(MrFileIndexTemp record);

    int insertSelective(MrFileIndexTemp record);

    MrFileIndexTemp selectByPrimaryKey(MrFileIndexTempKey key);

    int updateByPrimaryKeySelective(MrFileIndexTemp record);

    int updateByPrimaryKey(MrFileIndexTemp record);
}