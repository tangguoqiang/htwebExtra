package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugSupplierCatalog;

public interface DrugSupplierCatalogMapper {
    int deleteByPrimaryKey(String supplierId);

    int insert(DrugSupplierCatalog record);

    int insertSelective(DrugSupplierCatalog record);

    DrugSupplierCatalog selectByPrimaryKey(String supplierId);

    int updateByPrimaryKeySelective(DrugSupplierCatalog record);

    int updateByPrimaryKey(DrugSupplierCatalog record);
}