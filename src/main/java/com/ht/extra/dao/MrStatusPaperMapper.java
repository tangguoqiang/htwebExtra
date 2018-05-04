package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MrStatusPaperKey;

public interface MrStatusPaperMapper {
    int deleteByPrimaryKey(MrStatusPaperKey key);

    int insert(MrStatusPaperKey record);

    int insertSelective(MrStatusPaperKey record);
}