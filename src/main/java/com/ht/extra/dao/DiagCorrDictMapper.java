package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DiagCorrDict;

public interface DiagCorrDictMapper {
    int deleteByPrimaryKey(String diagCorrCode);

    int insert(DiagCorrDict record);

    int insertSelective(DiagCorrDict record);

    DiagCorrDict selectByPrimaryKey(String diagCorrCode);

    int updateByPrimaryKeySelective(DiagCorrDict record);

    int updateByPrimaryKey(DiagCorrDict record);
}