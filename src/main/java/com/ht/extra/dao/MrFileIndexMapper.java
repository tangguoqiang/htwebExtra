package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MrFileIndex;
import com.ht.extra.pojo.medrec.MrFileIndexKey;

public interface MrFileIndexMapper {
    int deleteByPrimaryKey(MrFileIndexKey key);

    int insert(MrFileIndex record);

    int insertSelective(MrFileIndex record);

    MrFileIndex selectByPrimaryKey(MrFileIndexKey key);

    int updateByPrimaryKeySelective(MrFileIndex record);

    int updateByPrimaryKey(MrFileIndex record);
}