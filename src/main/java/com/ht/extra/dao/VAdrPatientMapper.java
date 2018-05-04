package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.VAdrPatient;

public interface VAdrPatientMapper {
    int insert(VAdrPatient record);

    int insertSelective(VAdrPatient record);
}