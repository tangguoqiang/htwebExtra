package com.ht.extra.dao;

import com.ht.extra.pojo.comm.Samename;
import com.ht.extra.pojo.comm.SamenameKey;

public interface SamenameMapper {
    int deleteByPrimaryKey(SamenameKey key);

    int insert(Samename record);

    int insertSelective(Samename record);

    Samename selectByPrimaryKey(SamenameKey key);

    int updateByPrimaryKeySelective(Samename record);

    int updateByPrimaryKey(Samename record);
}