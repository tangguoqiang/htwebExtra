package com.ht.extra.dao;

import com.ht.extra.pojo.comm.MrValueDict;

public interface MrValueDictMapper {
    int deleteByPrimaryKey(String mrValueName);

    int insert(MrValueDict record);

    int insertSelective(MrValueDict record);

    MrValueDict selectByPrimaryKey(String mrValueName);

    int updateByPrimaryKeySelective(MrValueDict record);

    int updateByPrimaryKey(MrValueDict record);
}