package com.ht.extra.dao;

import com.ht.extra.pojo.comm.FileServers;
import com.ht.extra.pojo.comm.FileServersKey;

public interface FileServersMapper {
    int deleteByPrimaryKey(FileServersKey key);

    int insert(FileServers record);

    int insertSelective(FileServers record);

    FileServers selectByPrimaryKey(FileServersKey key);

    int updateByPrimaryKeySelective(FileServers record);

    int updateByPrimaryKey(FileServers record);
}