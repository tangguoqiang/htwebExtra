package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AllowLogin;

public interface AllowLoginMapper {
    int deleteByPrimaryKey(String userInDb);

    int insert(AllowLogin record);

    int insertSelective(AllowLogin record);

    AllowLogin selectByPrimaryKey(String userInDb);

    int updateByPrimaryKeySelective(AllowLogin record);

    int updateByPrimaryKey(AllowLogin record);
}