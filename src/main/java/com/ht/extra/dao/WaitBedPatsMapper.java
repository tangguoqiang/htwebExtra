package com.ht.extra.dao;

import com.ht.extra.pojo.inpadm.WaitBedPats;

public interface WaitBedPatsMapper {
    int deleteByPrimaryKey(Short waitNo);

    int insert(WaitBedPats record);

    int insertSelective(WaitBedPats record);

    WaitBedPats selectByPrimaryKey(Short waitNo);

    int updateByPrimaryKeySelective(WaitBedPats record);

    int updateByPrimaryKey(WaitBedPats record);
}