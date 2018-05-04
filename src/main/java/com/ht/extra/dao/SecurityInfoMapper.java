package com.ht.extra.dao;

import com.ht.extra.pojo.comm.SecurityInfo;
import com.ht.extra.pojo.comm.SecurityInfoKey;

public interface SecurityInfoMapper {
    int deleteByPrimaryKey(SecurityInfoKey key);

    int insert(SecurityInfo record);

    int insertSelective(SecurityInfo record);

    SecurityInfo selectByPrimaryKey(SecurityInfoKey key);

    int updateByPrimaryKeySelective(SecurityInfo record);

    int updateByPrimaryKey(SecurityInfo record);
}