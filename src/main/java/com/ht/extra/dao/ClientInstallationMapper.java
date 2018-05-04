package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ClientInstallation;

public interface ClientInstallationMapper {
    int deleteByPrimaryKey(String ipAddress);

    int insert(ClientInstallation record);

    int insertSelective(ClientInstallation record);

    ClientInstallation selectByPrimaryKey(String ipAddress);

    int updateByPrimaryKeySelective(ClientInstallation record);

    int updateByPrimaryKey(ClientInstallation record);
}