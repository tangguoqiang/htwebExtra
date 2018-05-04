package com.ht.extra.dao;

import com.ht.extra.pojo.comm.EraseLoginLog;

public interface EraseLoginLogMapper {
    int insert(EraseLoginLog record);

    int insertSelective(EraseLoginLog record);
}