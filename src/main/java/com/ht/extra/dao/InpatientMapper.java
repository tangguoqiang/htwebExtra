package com.ht.extra.dao;

import com.ht.extra.pojo.Inpatient;

import java.util.List;

public interface InpatientMapper {
    int deleteByPrimaryKey(String ipid);

    int insert(Inpatient record);

    int insertSelective(Inpatient record);

    Inpatient selectByPrimaryKey(String ipid);

    int updateByPrimaryKeySelective(Inpatient record);

    int updateByPrimaryKey(Inpatient record);

    List<Inpatient> selectByOutTime(String time1, String time2);

    List<Inpatient> selectLikeOutTime(String time);
}