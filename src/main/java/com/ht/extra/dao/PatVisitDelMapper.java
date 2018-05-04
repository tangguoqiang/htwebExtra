package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.PatVisitDel;
import com.ht.extra.pojo.medrec.PatVisitDelKey;

public interface PatVisitDelMapper {
    int deleteByPrimaryKey(PatVisitDelKey key);

    int insert(PatVisitDel record);

    int insertSelective(PatVisitDel record);

    PatVisitDel selectByPrimaryKey(PatVisitDelKey key);

    int updateByPrimaryKeySelective(PatVisitDel record);

    int updateByPrimaryKey(PatVisitDel record);
}