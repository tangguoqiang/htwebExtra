package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PoliclinicCodeTransition;
import com.ht.extra.pojo.comm.PoliclinicCodeTransitionKey;

public interface PoliclinicCodeTransitionMapper {
    int deleteByPrimaryKey(PoliclinicCodeTransitionKey key);

    int insert(PoliclinicCodeTransition record);

    int insertSelective(PoliclinicCodeTransition record);

    PoliclinicCodeTransition selectByPrimaryKey(PoliclinicCodeTransitionKey key);

    int updateByPrimaryKeySelective(PoliclinicCodeTransition record);

    int updateByPrimaryKey(PoliclinicCodeTransition record);
}