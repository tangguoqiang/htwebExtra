package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.VAdrDiagnose;

public interface VAdrDiagnoseMapper {
    int insert(VAdrDiagnose record);

    int insertSelective(VAdrDiagnose record);
}