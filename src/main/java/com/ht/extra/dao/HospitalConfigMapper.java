package com.ht.extra.dao;

import com.ht.extra.pojo.comm.HospitalConfig;

public interface HospitalConfigMapper {
    int deleteByPrimaryKey(String hospital);

    int insert(HospitalConfig record);

    int insertSelective(HospitalConfig record);

    HospitalConfig selectByPrimaryKey(String hospital);

    int updateByPrimaryKeySelective(HospitalConfig record);

    int updateByPrimaryKey(HospitalConfig record);
}