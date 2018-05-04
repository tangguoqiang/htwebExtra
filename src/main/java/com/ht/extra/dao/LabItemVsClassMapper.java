package com.ht.extra.dao;

import com.ht.extra.pojo.comm.LabItemVsClass;

public interface LabItemVsClassMapper {
    int deleteByPrimaryKey(String itemCode);

    int insert(LabItemVsClass record);

    int insertSelective(LabItemVsClass record);

    LabItemVsClass selectByPrimaryKey(String itemCode);

    int updateByPrimaryKeySelective(LabItemVsClass record);

    int updateByPrimaryKey(LabItemVsClass record);
}