package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.Transfer;
import com.ht.extra.pojo.medrec.TransferKey;

public interface TransferMapper {
    int deleteByPrimaryKey(TransferKey key);

    int insert(Transfer record);

    int insertSelective(Transfer record);

    Transfer selectByPrimaryKey(TransferKey key);

    int updateByPrimaryKeySelective(Transfer record);

    int updateByPrimaryKey(Transfer record);
}