package com.ht.extra.dao;

import com.ht.extra.pojo.comm.LabSheetItems;
import com.ht.extra.pojo.comm.LabSheetItemsKey;

public interface LabSheetItemsMapper {
    int deleteByPrimaryKey(LabSheetItemsKey key);

    int insert(LabSheetItems record);

    int insertSelective(LabSheetItems record);

    LabSheetItems selectByPrimaryKey(LabSheetItemsKey key);

    int updateByPrimaryKeySelective(LabSheetItems record);

    int updateByPrimaryKey(LabSheetItems record);
}