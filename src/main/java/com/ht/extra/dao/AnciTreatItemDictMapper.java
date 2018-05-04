package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AnciTreatItemDict;

public interface AnciTreatItemDictMapper {
    int deleteByPrimaryKey(String diagTreatCode);

    int insert(AnciTreatItemDict record);

    int insertSelective(AnciTreatItemDict record);

    AnciTreatItemDict selectByPrimaryKey(String diagTreatCode);

    int updateByPrimaryKeySelective(AnciTreatItemDict record);

    int updateByPrimaryKey(AnciTreatItemDict record);
}