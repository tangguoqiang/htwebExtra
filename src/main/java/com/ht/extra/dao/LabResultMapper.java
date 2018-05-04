package com.ht.extra.dao;

import com.ht.extra.pojo.lab.LabResult;
import com.ht.extra.pojo.lab.LabResultKey;

import java.util.List;

public interface LabResultMapper {
    int deleteByPrimaryKey(LabResultKey key);

    int insert(LabResult record);

    int insertSelective(LabResult record);

    LabResult selectByPrimaryKey(LabResultKey key);

    int updateByPrimaryKeySelective(LabResult record);

    int updateByPrimaryKey(LabResult record);

    List<LabResult> selectByTestNo(String testNo);
}