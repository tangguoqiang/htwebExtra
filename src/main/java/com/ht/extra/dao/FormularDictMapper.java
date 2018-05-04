package com.ht.extra.dao;

import com.ht.extra.pojo.lab.FormularDict;

public interface FormularDictMapper {
    int deleteByPrimaryKey(String computedCode);

    int insert(FormularDict record);

    int insertSelective(FormularDict record);

    FormularDict selectByPrimaryKey(String computedCode);

    int updateByPrimaryKeySelective(FormularDict record);

    int updateByPrimaryKey(FormularDict record);
}