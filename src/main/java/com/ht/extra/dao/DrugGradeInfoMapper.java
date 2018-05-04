package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugGradeInfo;
import com.ht.extra.pojo.comm.DrugGradeInfoKey;

public interface DrugGradeInfoMapper {
    int deleteByPrimaryKey(DrugGradeInfoKey key);

    int insert(DrugGradeInfo record);

    int insertSelective(DrugGradeInfo record);

    DrugGradeInfo selectByPrimaryKey(DrugGradeInfoKey key);

    int updateByPrimaryKeySelective(DrugGradeInfo record);

    int updateByPrimaryKey(DrugGradeInfo record);
}