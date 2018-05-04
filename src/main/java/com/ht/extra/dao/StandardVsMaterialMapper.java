package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StandardVsMaterial;
import com.ht.extra.pojo.comm.StandardVsMaterialKey;

public interface StandardVsMaterialMapper {
    int deleteByPrimaryKey(StandardVsMaterialKey key);

    int insert(StandardVsMaterial record);

    int insertSelective(StandardVsMaterial record);

    StandardVsMaterial selectByPrimaryKey(StandardVsMaterialKey key);

    int updateByPrimaryKeySelective(StandardVsMaterial record);

    int updateByPrimaryKey(StandardVsMaterial record);
}