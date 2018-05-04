package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.OutpMrTemplate;
import com.ht.extra.pojo.outpdoct.OutpMrTemplateKey;

public interface OutpMrTemplateMapper {
    int deleteByPrimaryKey(OutpMrTemplateKey key);

    int insert(OutpMrTemplate record);

    int insertSelective(OutpMrTemplate record);

    OutpMrTemplate selectByPrimaryKey(OutpMrTemplateKey key);

    int updateByPrimaryKeySelective(OutpMrTemplate record);

    int updateByPrimaryKey(OutpMrTemplate record);
}