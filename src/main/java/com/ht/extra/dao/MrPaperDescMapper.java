package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MrPaperDesc;
import com.ht.extra.pojo.medrec.MrPaperDescKey;

public interface MrPaperDescMapper {
    int deleteByPrimaryKey(MrPaperDescKey key);

    int insert(MrPaperDesc record);

    int insertSelective(MrPaperDesc record);

    MrPaperDesc selectByPrimaryKey(MrPaperDescKey key);

    int updateByPrimaryKeySelective(MrPaperDesc record);

    int updateByPrimaryKey(MrPaperDesc record);
}