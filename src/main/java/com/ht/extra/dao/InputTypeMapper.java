package com.ht.extra.dao;

import com.ht.extra.pojo.comm.InputType;

public interface InputTypeMapper {
    int deleteByPrimaryKey(String inputCode);

    int insert(InputType record);

    int insertSelective(InputType record);

    InputType selectByPrimaryKey(String inputCode);

    int updateByPrimaryKeySelective(InputType record);

    int updateByPrimaryKey(InputType record);
}