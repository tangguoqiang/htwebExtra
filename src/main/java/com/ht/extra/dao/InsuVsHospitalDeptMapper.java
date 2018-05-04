package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuVsHospitalDept;
import com.ht.extra.pojo.insurance.InsuVsHospitalDeptKey;

public  interface InsuVsHospitalDeptMapper
{
     int deleteByPrimaryKey(InsuVsHospitalDeptKey paramInsuVsHospitalDeptKey);

     int insert(InsuVsHospitalDept paramInsuVsHospitalDept);

     int insertSelective(InsuVsHospitalDept paramInsuVsHospitalDept);

     InsuVsHospitalDept selectByPrimaryKey(InsuVsHospitalDeptKey paramInsuVsHospitalDeptKey);

     int updateByPrimaryKeySelective(InsuVsHospitalDept paramInsuVsHospitalDept);

     int updateByPrimaryKey(InsuVsHospitalDept paramInsuVsHospitalDept);

     InsuVsHospitalDept selectByPrimaryByDeptCode(String paramString);
}
