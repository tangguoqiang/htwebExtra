package com.ht.extra.dao;

import com.ht.extra.pojo.comm.OfficialDrugCatalog;
import com.ht.extra.pojo.comm.OfficialDrugCatalogKey;

public interface OfficialDrugCatalogMapper {
    int deleteByPrimaryKey(OfficialDrugCatalogKey key);

    int insert(OfficialDrugCatalog record);

    int insertSelective(OfficialDrugCatalog record);

    OfficialDrugCatalog selectByPrimaryKey(OfficialDrugCatalogKey key);

    int updateByPrimaryKeySelective(OfficialDrugCatalog record);

    int updateByPrimaryKey(OfficialDrugCatalog record);
}