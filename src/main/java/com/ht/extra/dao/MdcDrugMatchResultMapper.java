package com.ht.extra.dao;

import com.ht.extra.pojo.comm.MdcDrugMatchResult;

public interface MdcDrugMatchResultMapper {
    int insert(MdcDrugMatchResult record);

    int insertSelective(MdcDrugMatchResult record);
}