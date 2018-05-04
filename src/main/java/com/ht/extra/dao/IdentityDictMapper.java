package com.ht.extra.dao;

import com.ht.extra.pojo.comm.IdentityDict;

public interface IdentityDictMapper {
    int deleteByPrimaryKey(String identityName);

    int insert(IdentityDict record);

    int insertSelective(IdentityDict record);

    IdentityDict selectByPrimaryKey(String identityName);

    int updateByPrimaryKeySelective(IdentityDict record);

    int updateByPrimaryKey(IdentityDict record);
}