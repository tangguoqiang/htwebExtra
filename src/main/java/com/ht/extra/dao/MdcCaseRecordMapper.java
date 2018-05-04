package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MdcCaseRecord;
import java.math.BigDecimal;

public interface MdcCaseRecordMapper {
    int deleteByPrimaryKey(BigDecimal serialNo);

    int insert(MdcCaseRecord record);

    int insertSelective(MdcCaseRecord record);

    MdcCaseRecord selectByPrimaryKey(BigDecimal serialNo);

    int updateByPrimaryKeySelective(MdcCaseRecord record);

    int updateByPrimaryKeyWithBLOBs(MdcCaseRecord record);

    int updateByPrimaryKey(MdcCaseRecord record);
}