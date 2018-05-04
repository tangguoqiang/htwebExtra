package com.ht.extra.dao;

import com.ht.extra.pojo.comm.SecurityTemplate;
import com.ht.extra.pojo.comm.SecurityTemplateKey;

public interface SecurityTemplateMapper {
    int deleteByPrimaryKey(SecurityTemplateKey key);

    int insert(SecurityTemplate record);

    int insertSelective(SecurityTemplate record);

    SecurityTemplate selectByPrimaryKey(SecurityTemplateKey key);

    int updateByPrimaryKeySelective(SecurityTemplate record);

    int updateByPrimaryKey(SecurityTemplate record);
}