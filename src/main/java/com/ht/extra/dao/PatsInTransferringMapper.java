package com.ht.extra.dao;

import com.ht.extra.pojo.inpadm.PatsInTransferring;

public interface PatsInTransferringMapper {
    int deleteByPrimaryKey(String patientId);

    int insert(PatsInTransferring record);

    int insertSelective(PatsInTransferring record);

    PatsInTransferring selectByPrimaryKey(String patientId);

    int updateByPrimaryKeySelective(PatsInTransferring record);

    int updateByPrimaryKey(PatsInTransferring record);
}