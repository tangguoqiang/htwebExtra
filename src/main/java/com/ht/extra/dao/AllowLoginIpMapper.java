package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AllowLoginIp;

public interface AllowLoginIpMapper {
    int deleteByPrimaryKey(String ipAddress);

    int insert(AllowLoginIp record);

    int insertSelective(AllowLoginIp record);

    AllowLoginIp selectByPrimaryKey(String ipAddress);

    int updateByPrimaryKeySelective(AllowLoginIp record);

    int updateByPrimaryKey(AllowLoginIp record);
}