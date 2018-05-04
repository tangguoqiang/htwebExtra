package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MrTempletIndex;

public interface MrTempletIndexMapper {
    int deleteByPrimaryKey(String templetId);

    int insert(MrTempletIndex record);

    int insertSelective(MrTempletIndex record);

    MrTempletIndex selectByPrimaryKey(String templetId);

    int updateByPrimaryKeySelective(MrTempletIndex record);

    int updateByPrimaryKey(MrTempletIndex record);
}