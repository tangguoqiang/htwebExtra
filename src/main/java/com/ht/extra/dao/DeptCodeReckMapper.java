package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptCodeReck;
import com.ht.extra.pojo.comm.DeptCodeReckKey;

public interface DeptCodeReckMapper {
    int deleteByPrimaryKey(DeptCodeReckKey key);

    int insert(DeptCodeReck record);

    int insertSelective(DeptCodeReck record);

    DeptCodeReck selectByPrimaryKey(DeptCodeReckKey key);

    int updateByPrimaryKeySelective(DeptCodeReck record);

    int updateByPrimaryKey(DeptCodeReck record);
}