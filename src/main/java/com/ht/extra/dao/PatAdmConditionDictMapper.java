package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PatAdmConditionDict;

public interface PatAdmConditionDictMapper {
    int deleteByPrimaryKey(String patConditionCode);

    int insert(PatAdmConditionDict record);

    int insertSelective(PatAdmConditionDict record);

    PatAdmConditionDict selectByPrimaryKey(String patConditionCode);

    int updateByPrimaryKeySelective(PatAdmConditionDict record);

    int updateByPrimaryKey(PatAdmConditionDict record);
}