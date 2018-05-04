package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.InsuranceInputSetting;
import com.ht.extra.pojo.insurance.InsuranceInputSettingKey;

public interface InsuranceInputSettingMapper {
    int deleteByPrimaryKey(InsuranceInputSettingKey key);

    int insert(InsuranceInputSetting record);

    int insertSelective(InsuranceInputSetting record);

    InsuranceInputSetting selectByPrimaryKey(InsuranceInputSettingKey key);

    int updateByPrimaryKeySelective(InsuranceInputSetting record);

    int updateByPrimaryKey(InsuranceInputSetting record);
}