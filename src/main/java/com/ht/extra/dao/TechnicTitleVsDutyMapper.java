package com.ht.extra.dao;

import com.ht.extra.pojo.comm.TechnicTitleVsDuty;
import com.ht.extra.pojo.comm.TechnicTitleVsDutyKey;

public interface TechnicTitleVsDutyMapper {
    int deleteByPrimaryKey(TechnicTitleVsDutyKey key);

    int insert(TechnicTitleVsDuty record);

    int insertSelective(TechnicTitleVsDuty record);

    TechnicTitleVsDuty selectByPrimaryKey(TechnicTitleVsDutyKey key);

    int updateByPrimaryKeySelective(TechnicTitleVsDuty record);

    int updateByPrimaryKey(TechnicTitleVsDuty record);
}