package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MrAddDays;
import com.ht.extra.pojo.medrec.MrAddDaysKey;

public interface MrAddDaysMapper {
    int deleteByPrimaryKey(MrAddDaysKey key);

    int insert(MrAddDays record);

    int insertSelective(MrAddDays record);

    MrAddDays selectByPrimaryKey(MrAddDaysKey key);

    int updateByPrimaryKeySelective(MrAddDays record);

    int updateByPrimaryKey(MrAddDays record);
}