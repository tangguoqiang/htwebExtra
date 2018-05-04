package com.ht.extra.dao;

import com.ht.extra.pojo.comm.Ka02;
import com.ht.extra.pojo.comm.Ka02Key;

public interface Ka02Mapper {
    int deleteByPrimaryKey(Ka02Key key);

    int insert(Ka02 record);

    int insertSelective(Ka02 record);

    Ka02 selectByPrimaryKey(Ka02Key key);

    int updateByPrimaryKeySelective(Ka02 record);

    int updateByPrimaryKey(Ka02 record);
}