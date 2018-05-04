package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OuterGeneration;

public interface OuterGenerationMapper {
    int deleteByPrimaryKey(String dictFileName);

    int insert(OuterGeneration record);

    int insertSelective(OuterGeneration record);

    OuterGeneration selectByPrimaryKey(String dictFileName);

    int updateByPrimaryKeySelective(OuterGeneration record);

    int updateByPrimaryKeyWithBLOBs(OuterGeneration record);

    int updateByPrimaryKey(OuterGeneration record);
}