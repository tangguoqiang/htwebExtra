package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DischargeDispositionDict;

public interface DischargeDispositionDictMapper {
    int deleteByPrimaryKey(String dischargeDispositionCode);

    int insert(DischargeDispositionDict record);

    int insertSelective(DischargeDispositionDict record);

    DischargeDispositionDict selectByPrimaryKey(String dischargeDispositionCode);

    int updateByPrimaryKeySelective(DischargeDispositionDict record);

    int updateByPrimaryKey(DischargeDispositionDict record);
}