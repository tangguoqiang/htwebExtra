package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AppGrants;
import com.ht.extra.pojo.comm.AppGrantsKey;

public interface AppGrantsMapper {
    int deleteByPrimaryKey(AppGrantsKey key);

    int insert(AppGrants record);

    int insertSelective(AppGrants record);

    AppGrants selectByPrimaryKey(AppGrantsKey key);

    int updateByPrimaryKeySelective(AppGrants record);

    int updateByPrimaryKey(AppGrants record);
}