package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptDict;

import java.util.List;

public interface DeptDictMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(DeptDict record);

    int insertSelective(DeptDict record);

    DeptDict selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(DeptDict record);

    List<DeptDict> selectByAll();

    List<DeptDict> selectByAllByMZ();

    DeptDict selectDeptLocation(String rcptNo);
}