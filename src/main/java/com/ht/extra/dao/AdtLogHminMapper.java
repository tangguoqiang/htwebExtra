package com.ht.extra.dao;

import com.ht.extra.pojo.inpadm.AdtLogHmin;
import com.ht.extra.pojo.inpadm.AdtLogHminKey;

public interface AdtLogHminMapper {
    int deleteByPrimaryKey(AdtLogHminKey key);

    int insert(AdtLogHmin record);

    int insertSelective(AdtLogHmin record);

    AdtLogHmin selectByPrimaryKey(AdtLogHminKey key);

    int updateByPrimaryKeySelective(AdtLogHmin record);

    int updateByPrimaryKey(AdtLogHmin record);
}