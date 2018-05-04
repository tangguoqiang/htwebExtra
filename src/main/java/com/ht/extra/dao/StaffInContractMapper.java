package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StaffInContract;
import com.ht.extra.pojo.comm.StaffInContractKey;

public interface StaffInContractMapper {
    int deleteByPrimaryKey(StaffInContractKey key);

    int insert(StaffInContract record);

    int insertSelective(StaffInContract record);

    StaffInContract selectByPrimaryKey(StaffInContractKey key);

    int updateByPrimaryKeySelective(StaffInContract record);

    int updateByPrimaryKey(StaffInContract record);
}