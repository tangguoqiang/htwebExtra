package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuDoctorDict;
import java.util.List;

public  interface InsuDoctorDictMapper
{
    int deleteByPrimaryKey(String paramString);

    int insert(InsuDoctorDict paramInsuDoctorDict);

    int insertSelective(InsuDoctorDict paramInsuDoctorDict);

    InsuDoctorDict selectByPrimaryKey(String paramString);

    int updateByPrimaryKeySelective(InsuDoctorDict paramInsuDoctorDict);

    int updateByPrimaryKey(InsuDoctorDict paramInsuDoctorDict);

    List<InsuDoctorDict> selectByDoctorName(String paramString);
}
