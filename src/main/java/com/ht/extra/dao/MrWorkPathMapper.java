package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MrWorkPath;

public interface MrWorkPathMapper {
    int deleteByPrimaryKey(String mrPath);

    int insert(MrWorkPath record);

    int insertSelective(MrWorkPath record);

    MrWorkPath selectByPrimaryKey(String mrPath);

    int updateByPrimaryKeySelective(MrWorkPath record);

    int updateByPrimaryKey(MrWorkPath record);
}