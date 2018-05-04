package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptCodeDj;
import com.ht.extra.pojo.comm.DeptCodeDjKey;

public interface DeptCodeDjMapper {
    int deleteByPrimaryKey(DeptCodeDjKey key);

    int insert(DeptCodeDj record);

    int insertSelective(DeptCodeDj record);

    DeptCodeDj selectByPrimaryKey(DeptCodeDjKey key);

    int updateByPrimaryKeySelective(DeptCodeDj record);

    int updateByPrimaryKey(DeptCodeDj record);
}