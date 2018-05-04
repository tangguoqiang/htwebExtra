package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.OutpRcptMasterBack;

public interface OutpRcptMasterBackMapper {
    int deleteByPrimaryKey(String rcptNo);

    int insert(OutpRcptMasterBack record);

    int insertSelective(OutpRcptMasterBack record);

    OutpRcptMasterBack selectByPrimaryKey(String rcptNo);

    int updateByPrimaryKeySelective(OutpRcptMasterBack record);

    int updateByPrimaryKey(OutpRcptMasterBack record);
}