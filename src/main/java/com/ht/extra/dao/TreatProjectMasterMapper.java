package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.TreatProjectMaster;

public interface TreatProjectMasterMapper {
    int deleteByPrimaryKey(String treatProjectId);

    int insert(TreatProjectMaster record);

    int insertSelective(TreatProjectMaster record);

    TreatProjectMaster selectByPrimaryKey(String treatProjectId);

    int updateByPrimaryKeySelective(TreatProjectMaster record);

    int updateByPrimaryKey(TreatProjectMaster record);
}