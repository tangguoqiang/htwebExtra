package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.OutpOtherHospitalDrugInfo;
import com.ht.extra.pojo.outpadm.OutpOtherHospitalDrugInfoKey;

public interface OutpOtherHospitalDrugInfoMapper {
    int deleteByPrimaryKey(OutpOtherHospitalDrugInfoKey key);

    int insert(OutpOtherHospitalDrugInfo record);

    int insertSelective(OutpOtherHospitalDrugInfo record);

    OutpOtherHospitalDrugInfo selectByPrimaryKey(OutpOtherHospitalDrugInfoKey key);

    int updateByPrimaryKeySelective(OutpOtherHospitalDrugInfo record);

    int updateByPrimaryKey(OutpOtherHospitalDrugInfo record);
}