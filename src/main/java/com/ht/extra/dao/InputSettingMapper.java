package com.ht.extra.dao;

import com.ht.extra.pojo.comm.InputSetting;
import com.ht.extra.pojo.comm.InputSettingKey;

public interface InputSettingMapper {
    int deleteByPrimaryKey(InputSettingKey key);

    int insert(InputSetting record);

    int insertSelective(InputSetting record);

    InputSetting selectByPrimaryKey(InputSettingKey key);

    int updateByPrimaryKeySelective(InputSetting record);

    int updateByPrimaryKey(InputSetting record);
}