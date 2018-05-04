package com.ht.extra.dao;

import com.ht.extra.pojo.comm.BillPatternMaster;

public interface BillPatternMasterMapper {
    int deleteByPrimaryKey(String patternName);

    int insert(BillPatternMaster record);

    int insertSelective(BillPatternMaster record);

    BillPatternMaster selectByPrimaryKey(String patternName);

    int updateByPrimaryKeySelective(BillPatternMaster record);

    int updateByPrimaryKey(BillPatternMaster record);
}