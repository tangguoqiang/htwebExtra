package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.BillDeptConfig;

public interface BillDeptConfigMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(BillDeptConfig record);

    int insertSelective(BillDeptConfig record);
}