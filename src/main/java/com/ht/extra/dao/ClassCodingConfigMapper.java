package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ClassCodingConfig;

public interface ClassCodingConfigMapper {
    int deleteByPrimaryKey(String item);

    int insert(ClassCodingConfig record);

    int insertSelective(ClassCodingConfig record);

    ClassCodingConfig selectByPrimaryKey(String item);

    int updateByPrimaryKeySelective(ClassCodingConfig record);

    int updateByPrimaryKey(ClassCodingConfig record);
}