package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptEquip;

public interface DeptEquipMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(DeptEquip record);

    int insertSelective(DeptEquip record);

    DeptEquip selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(DeptEquip record);

    int updateByPrimaryKeyWithBLOBs(DeptEquip record);

    int updateByPrimaryKey(DeptEquip record);
}