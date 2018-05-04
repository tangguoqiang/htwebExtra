package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptExamItemDictKey;

public interface DeptExamItemDictMapper {
    int deleteByPrimaryKey(DeptExamItemDictKey key);

    int insert(DeptExamItemDictKey record);

    int insertSelective(DeptExamItemDictKey record);
}