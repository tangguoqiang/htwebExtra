package com.ht.extra.dao;

import com.ht.extra.pojo.comm.Applications;

public interface ApplicationsMapper {
    int deleteByPrimaryKey(String application);

    int insert(Applications record);

    int insertSelective(Applications record);

    Applications selectByPrimaryKey(String application);

    int updateByPrimaryKeySelective(Applications record);

    int updateByPrimaryKey(Applications record);
}