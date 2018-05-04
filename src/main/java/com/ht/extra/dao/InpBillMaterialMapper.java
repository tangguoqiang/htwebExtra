package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.InpBillMaterial;
import com.ht.extra.pojo.inpbill.InpBillMaterialKey;

public interface InpBillMaterialMapper {
    int deleteByPrimaryKey(InpBillMaterialKey key);

    int insert(InpBillMaterial record);

    int insertSelective(InpBillMaterial record);

    InpBillMaterial selectByPrimaryKey(InpBillMaterialKey key);

    int updateByPrimaryKeySelective(InpBillMaterial record);

    int updateByPrimaryKey(InpBillMaterial record);
}