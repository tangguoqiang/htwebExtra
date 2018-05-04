package com.ht.extra.dao;

import com.ht.extra.pojo.comm.NursingClassDict;

public interface NursingClassDictMapper {
    int deleteByPrimaryKey(String nursingClassCode);

    int insert(NursingClassDict record);

    int insertSelective(NursingClassDict record);

    NursingClassDict selectByPrimaryKey(String nursingClassCode);

    int updateByPrimaryKeySelective(NursingClassDict record);

    int updateByPrimaryKey(NursingClassDict record);
}