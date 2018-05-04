package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DeptClinicAttrDict;

public interface DeptClinicAttrDictMapper {
    int deleteByPrimaryKey(Short clinicAttrCode);

    int insert(DeptClinicAttrDict record);

    int insertSelective(DeptClinicAttrDict record);

    DeptClinicAttrDict selectByPrimaryKey(Short clinicAttrCode);

    int updateByPrimaryKeySelective(DeptClinicAttrDict record);

    int updateByPrimaryKey(DeptClinicAttrDict record);
}