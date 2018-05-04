package com.ht.extra.dao;

import com.ht.extra.pojo.lab.LabDeptTestDay;
import com.ht.extra.pojo.lab.LabDeptTestDayKey;

public interface LabDeptTestDayMapper {
    int deleteByPrimaryKey(LabDeptTestDayKey key);

    int insert(LabDeptTestDay record);

    int insertSelective(LabDeptTestDay record);

    LabDeptTestDay selectByPrimaryKey(LabDeptTestDayKey key);

    int updateByPrimaryKeySelective(LabDeptTestDay record);

    int updateByPrimaryKey(LabDeptTestDay record);
}