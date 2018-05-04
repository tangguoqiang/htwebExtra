package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.BindingPrescMaster;

public interface BindingPrescMasterMapper {
    int deleteByPrimaryKey(Short prescId);

    int insert(BindingPrescMaster record);

    int insertSelective(BindingPrescMaster record);

    BindingPrescMaster selectByPrimaryKey(Short prescId);

    int updateByPrimaryKeySelective(BindingPrescMaster record);

    int updateByPrimaryKey(BindingPrescMaster record);
}