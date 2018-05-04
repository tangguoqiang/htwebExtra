package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StaffGroupClassDict;

public interface StaffGroupClassDictMapper {
    int deleteByPrimaryKey(String groupClass);

    int insert(StaffGroupClassDict record);

    int insertSelective(StaffGroupClassDict record);

    StaffGroupClassDict selectByPrimaryKey(String groupClass);

    int updateByPrimaryKeySelective(StaffGroupClassDict record);

    int updateByPrimaryKey(StaffGroupClassDict record);
}