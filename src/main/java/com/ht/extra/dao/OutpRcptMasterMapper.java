package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.OutpRcptMaster;

public interface OutpRcptMasterMapper {
    int deleteByPrimaryKey(String rcptNo);

    int insert(OutpRcptMaster record);

    int insertSelective(OutpRcptMaster record);

    OutpRcptMaster selectByPrimaryKey(String rcptNo);

    int updateByPrimaryKeySelective(OutpRcptMaster record);

    int updateByPrimaryKey(OutpRcptMaster record);
}