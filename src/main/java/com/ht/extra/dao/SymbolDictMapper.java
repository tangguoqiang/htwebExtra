package com.ht.extra.dao;

import com.ht.extra.pojo.lab.SymbolDict;

public interface SymbolDictMapper {
    int deleteByPrimaryKey(String itemCode);

    int insert(SymbolDict record);

    int insertSelective(SymbolDict record);

    SymbolDict selectByPrimaryKey(String itemCode);

    int updateByPrimaryKeySelective(SymbolDict record);

    int updateByPrimaryKey(SymbolDict record);
}