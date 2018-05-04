package com.ht.extra.dao;

import com.ht.extra.pojo.lab.QualityConParameterList;
import com.ht.extra.pojo.lab.QualityConParameterListKey;

public interface QualityConParameterListMapper {
    int deleteByPrimaryKey(QualityConParameterListKey key);

    int insert(QualityConParameterList record);

    int insertSelective(QualityConParameterList record);

    QualityConParameterList selectByPrimaryKey(QualityConParameterListKey key);

    int updateByPrimaryKeySelective(QualityConParameterList record);

    int updateByPrimaryKey(QualityConParameterList record);
}