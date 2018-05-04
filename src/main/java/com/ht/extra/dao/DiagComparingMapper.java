package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.DiagComparing;
import com.ht.extra.pojo.medrec.DiagComparingKey;

public interface DiagComparingMapper {
    int deleteByPrimaryKey(DiagComparingKey key);

    int insert(DiagComparing record);

    int insertSelective(DiagComparing record);

    DiagComparing selectByPrimaryKey(DiagComparingKey key);

    int updateByPrimaryKeySelective(DiagComparing record);

    int updateByPrimaryKey(DiagComparing record);
}