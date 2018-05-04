package com.ht.extra.dao;

import com.ht.extra.pojo.comm.JobClassDict;

public interface JobClassDictMapper {
    int deleteByPrimaryKey(String jobClassName);

    int insert(JobClassDict record);

    int insertSelective(JobClassDict record);

    JobClassDict selectByPrimaryKey(String jobClassName);

    int updateByPrimaryKeySelective(JobClassDict record);

    int updateByPrimaryKey(JobClassDict record);
}