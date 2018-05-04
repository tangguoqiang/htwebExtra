package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.DiagnosticCategory;
import com.ht.extra.pojo.medrec.DiagnosticCategoryKey;

public interface DiagnosticCategoryMapper {
    int deleteByPrimaryKey(DiagnosticCategoryKey key);

    int insert(DiagnosticCategory record);

    int insertSelective(DiagnosticCategory record);

    DiagnosticCategory selectByPrimaryKey(DiagnosticCategoryKey key);

    int updateByPrimaryKeySelective(DiagnosticCategory record);

    int updateByPrimaryKey(DiagnosticCategory record);
}