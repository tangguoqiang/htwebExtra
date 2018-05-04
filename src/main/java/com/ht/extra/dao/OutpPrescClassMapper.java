package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OutpPrescClass;

public interface OutpPrescClassMapper {
    int deleteByPrimaryKey(String prescClass);

    int insert(OutpPrescClass record);

    int insertSelective(OutpPrescClass record);

    OutpPrescClass selectByPrimaryKey(String prescClass);

    int updateByPrimaryKeySelective(OutpPrescClass record);

    int updateByPrimaryKey(OutpPrescClass record);
}