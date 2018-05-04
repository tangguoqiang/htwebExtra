package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StaffGroupDict;
import com.ht.extra.pojo.comm.StaffGroupDictKey;

public interface StaffGroupDictMapper {
    int deleteByPrimaryKey(StaffGroupDictKey key);

    int insert(StaffGroupDict record);

    int insertSelective(StaffGroupDict record);

    StaffGroupDict selectByPrimaryKey(StaffGroupDictKey key);

    int updateByPrimaryKeySelective(StaffGroupDict record);

    int updateByPrimaryKey(StaffGroupDict record);
}