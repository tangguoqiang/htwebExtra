package com.ht.extra.dao;

import com.ht.extra.pojo.lab.LabDeptTestMonth;
import com.ht.extra.pojo.lab.LabDeptTestMonthKey;

public interface LabDeptTestMonthMapper {
    int deleteByPrimaryKey(LabDeptTestMonthKey key);

    int insert(LabDeptTestMonth record);

    int insertSelective(LabDeptTestMonth record);

    LabDeptTestMonth selectByPrimaryKey(LabDeptTestMonthKey key);

    int updateByPrimaryKeySelective(LabDeptTestMonth record);

    int updateByPrimaryKey(LabDeptTestMonth record);
}