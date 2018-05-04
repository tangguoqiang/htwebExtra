package com.ht.extra.dao;

import com.ht.extra.pojo.comm.AppConfigerParameter;
import com.ht.extra.pojo.comm.AppConfigerParameterKey;

public interface AppConfigerParameterMapper {
    int deleteByPrimaryKey(AppConfigerParameterKey key);

    int insert(AppConfigerParameter record);

    int insertSelective(AppConfigerParameter record);

    AppConfigerParameter selectByPrimaryKey(AppConfigerParameterKey key);

    int updateByPrimaryKeySelective(AppConfigerParameter record);

    int updateByPrimaryKey(AppConfigerParameter record);

    AppConfigerParameter selectByParameterName(String njjb_control);
}