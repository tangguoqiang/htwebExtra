package com.ht.extra.dao;

import com.ht.extra.pojo.lab.LabTestItems;
import com.ht.extra.pojo.lab.LabTestItemsKey;

public interface LabTestItemsMapper {
    int deleteByPrimaryKey(LabTestItemsKey key);

    int insert(LabTestItems record);

    int insertSelective(LabTestItems record);

    LabTestItems selectByPrimaryKey(LabTestItemsKey key);

    int updateByPrimaryKeySelective(LabTestItems record);

    int updateByPrimaryKey(LabTestItems record);
}