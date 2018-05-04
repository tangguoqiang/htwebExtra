package com.ht.extra.dao;

import com.ht.extra.pojo.lab.QualityConList;
import com.ht.extra.pojo.lab.QualityConListKey;

public interface QualityConListMapper {
    int deleteByPrimaryKey(QualityConListKey key);

    int insert(QualityConList record);

    int insertSelective(QualityConList record);

    QualityConList selectByPrimaryKey(QualityConListKey key);

    int updateByPrimaryKeySelective(QualityConList record);

    int updateByPrimaryKey(QualityConList record);
}