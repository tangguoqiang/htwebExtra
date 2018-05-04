package com.ht.extra.dao;

import com.ht.extra.pojo.comm.MeasuresDict;
import com.ht.extra.pojo.comm.MeasuresDictKey;

public interface MeasuresDictMapper {
    int deleteByPrimaryKey(MeasuresDictKey key);

    int insert(MeasuresDict record);

    int insertSelective(MeasuresDict record);

    MeasuresDict selectByPrimaryKey(MeasuresDictKey key);

    int updateByPrimaryKeySelective(MeasuresDict record);

    int updateByPrimaryKey(MeasuresDict record);
}