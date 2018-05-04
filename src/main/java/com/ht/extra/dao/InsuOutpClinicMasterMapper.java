package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuOutpClinicMaster;
import com.ht.extra.pojo.insurance.InsuOutpClinicMasterKey;

public interface InsuOutpClinicMasterMapper {
    int deleteByPrimaryKey(InsuOutpClinicMasterKey key);

    int insert(InsuOutpClinicMaster record);

    int insertSelective(InsuOutpClinicMaster record);

    InsuOutpClinicMaster selectByPrimaryKey(InsuOutpClinicMasterKey key);

    int updateByPrimaryKeySelective(InsuOutpClinicMaster record);

    int updateByPrimaryKey(InsuOutpClinicMaster record);
}