package com.ht.extra.dao;

import com.ht.extra.pojo.comm.TallySubjectDict;

public interface TallySubjectDictMapper {
    int deleteByPrimaryKey(String subjCode);

    int insert(TallySubjectDict record);

    int insertSelective(TallySubjectDict record);

    TallySubjectDict selectByPrimaryKey(String subjCode);

    int updateByPrimaryKeySelective(TallySubjectDict record);

    int updateByPrimaryKey(TallySubjectDict record);
}