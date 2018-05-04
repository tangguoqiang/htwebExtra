package com.ht.extra.dao;

import com.ht.extra.pojo.comm.HospitalVsInsurance;
import com.ht.extra.pojo.comm.HospitalVsInsuranceKey;

public interface HospitalVsInsuranceMapper {
    int deleteByPrimaryKey(HospitalVsInsuranceKey key);

    int insert(HospitalVsInsurance record);

    int insertSelective(HospitalVsInsurance record);

    HospitalVsInsurance selectByPrimaryKey(HospitalVsInsuranceKey key);

    int updateByPrimaryKeySelective(HospitalVsInsurance record);

    int updateByPrimaryKey(HospitalVsInsurance record);
}