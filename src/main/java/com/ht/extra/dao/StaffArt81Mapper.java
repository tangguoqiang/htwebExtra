package com.ht.extra.dao;

import com.ht.extra.pojo.comm.StaffArt81;

public interface StaffArt81Mapper {
    int deleteByPrimaryKey(String artCode);

    int insert(StaffArt81 record);

    int insertSelective(StaffArt81 record);

    StaffArt81 selectByPrimaryKey(String artCode);

    int updateByPrimaryKeySelective(StaffArt81 record);

    int updateByPrimaryKey(StaffArt81 record);
}