package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ApplicationKey;

public interface ApplicationKeyMapper {
    int insert(ApplicationKey record);

    int insertSelective(ApplicationKey record);
}