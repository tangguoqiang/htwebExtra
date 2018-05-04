package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.CasherWorkingLog;
import com.ht.extra.pojo.inpbill.CasherWorkingLogKey;

public interface CasherWorkingLogMapper {
    int deleteByPrimaryKey(CasherWorkingLogKey key);

    int insert(CasherWorkingLog record);

    int insertSelective(CasherWorkingLog record);

    CasherWorkingLog selectByPrimaryKey(CasherWorkingLogKey key);

    int updateByPrimaryKeySelective(CasherWorkingLog record);

    int updateByPrimaryKey(CasherWorkingLog record);
}