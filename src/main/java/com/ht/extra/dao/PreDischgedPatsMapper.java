package com.ht.extra.dao;

import com.ht.extra.pojo.inpadm.PreDischgedPats;

public interface PreDischgedPatsMapper {
    int deleteByPrimaryKey(String patientId);

    int insert(PreDischgedPats record);

    int insertSelective(PreDischgedPats record);

    PreDischgedPats selectByPrimaryKey(String patientId);

    int updateByPrimaryKeySelective(PreDischgedPats record);

    int updateByPrimaryKey(PreDischgedPats record);
}