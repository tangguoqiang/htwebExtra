package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.VAdrVisit;

public interface VAdrVisitMapper {
    int insert(VAdrVisit record);

    int insertSelective(VAdrVisit record);
}