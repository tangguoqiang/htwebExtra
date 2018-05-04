package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ServiceSystemDict;

public interface ServiceSystemDictMapper {
    int deleteByPrimaryKey(Short serviceSystemCode);

    int insert(ServiceSystemDict record);

    int insertSelective(ServiceSystemDict record);

    ServiceSystemDict selectByPrimaryKey(Short serviceSystemCode);

    int updateByPrimaryKeySelective(ServiceSystemDict record);

    int updateByPrimaryKey(ServiceSystemDict record);
}