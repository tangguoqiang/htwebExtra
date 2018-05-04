package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ChargeTypeVsIdentity;
import com.ht.extra.pojo.comm.ChargeTypeVsIdentityKey;

public interface ChargeTypeVsIdentityMapper {
    int deleteByPrimaryKey(ChargeTypeVsIdentityKey key);

    int insert(ChargeTypeVsIdentity record);

    int insertSelective(ChargeTypeVsIdentity record);

    ChargeTypeVsIdentity selectByPrimaryKey(ChargeTypeVsIdentityKey key);

    int updateByPrimaryKeySelective(ChargeTypeVsIdentity record);

    int updateByPrimaryKey(ChargeTypeVsIdentity record);
}