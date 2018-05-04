package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.ClinicIndex;

import java.util.Date;
import java.util.List;

public interface ClinicIndexMapper {
    int deleteByPrimaryKey(String clinicLabel);

    int insert(ClinicIndex record);

    int insertSelective(ClinicIndex record);

    ClinicIndex selectByPrimaryKey(String clinicLabel);

    int updateByPrimaryKeySelective(ClinicIndex record);

    int updateByPrimaryKey(ClinicIndex record);

    List<ClinicIndex> selectByDept(String clinicdept);

}