package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.VMrPatPutTime;

public interface VMrPatPutTimeMapper {
    int insert(VMrPatPutTime record);

    int insertSelective(VMrPatPutTime record);
}