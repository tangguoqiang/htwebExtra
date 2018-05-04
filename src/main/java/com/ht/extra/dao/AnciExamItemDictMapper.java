package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AnciExamItemDict;

public interface AnciExamItemDictMapper {
    int deleteByPrimaryKey(String diagExamCode);

    int insert(AnciExamItemDict record);

    int insertSelective(AnciExamItemDict record);

    AnciExamItemDict selectByPrimaryKey(String diagExamCode);

    int updateByPrimaryKeySelective(AnciExamItemDict record);

    int updateByPrimaryKey(AnciExamItemDict record);
}