package com.ht.extra.dao;

import com.ht.extra.pojo.inpadm.AdtLog;
import com.ht.extra.pojo.inpadm.AdtLogKey;
import org.springframework.transaction.annotation.Transactional;

public interface AdtLogMapper {
    int deleteByPrimaryKey(AdtLogKey key);

    int insert(AdtLog record);

    int insertSelective(AdtLog record);

    AdtLog selectByPrimaryKey(AdtLogKey key);

    int updateByPrimaryKeySelective(AdtLog record);

    int updateByPrimaryKey(AdtLog record);
}