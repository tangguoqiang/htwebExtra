package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ClinicalDeptConfig;

public interface ClinicalDeptConfigMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(ClinicalDeptConfig record);

    int insertSelective(ClinicalDeptConfig record);

    ClinicalDeptConfig selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(ClinicalDeptConfig record);

    int updateByPrimaryKey(ClinicalDeptConfig record);
}