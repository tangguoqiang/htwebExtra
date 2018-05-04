package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.BloodTransfusion;
import com.ht.extra.pojo.medrec.BloodTransfusionKey;

public interface BloodTransfusionMapper {
    int deleteByPrimaryKey(BloodTransfusionKey key);

    int insert(BloodTransfusion record);

    int insertSelective(BloodTransfusion record);

    BloodTransfusion selectByPrimaryKey(BloodTransfusionKey key);

    int updateByPrimaryKeySelective(BloodTransfusion record);

    int updateByPrimaryKey(BloodTransfusion record);
}