package com.ht.extra.dao;

import com.ht.extra.pojo.outpbill.OutpBillMaterial;
import com.ht.extra.pojo.outpbill.OutpBillMaterialKey;

public interface OutpBillMaterialMapper {
    int deleteByPrimaryKey(OutpBillMaterialKey key);

    int insert(OutpBillMaterial record);

    int insertSelective(OutpBillMaterial record);

    OutpBillMaterial selectByPrimaryKey(OutpBillMaterialKey key);

    int updateByPrimaryKeySelective(OutpBillMaterial record);

    int updateByPrimaryKey(OutpBillMaterial record);
}