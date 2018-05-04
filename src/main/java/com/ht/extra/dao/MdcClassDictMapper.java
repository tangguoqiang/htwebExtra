package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MdcClassDict;
import java.math.BigDecimal;

public interface MdcClassDictMapper {
    int deleteByPrimaryKey(BigDecimal serialNo);

    int insert(MdcClassDict record);

    int insertSelective(MdcClassDict record);

    MdcClassDict selectByPrimaryKey(BigDecimal serialNo);

    int updateByPrimaryKeySelective(MdcClassDict record);

    int updateByPrimaryKey(MdcClassDict record);
}