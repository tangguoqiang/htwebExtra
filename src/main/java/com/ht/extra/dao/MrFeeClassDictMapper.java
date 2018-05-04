package com.ht.extra.dao;

import com.ht.extra.pojo.comm.MrFeeClassDict;

public interface MrFeeClassDictMapper {
    int deleteByPrimaryKey(String mrFeeClassCode);

    int insert(MrFeeClassDict record);

    int insertSelective(MrFeeClassDict record);

    MrFeeClassDict selectByPrimaryKey(String mrFeeClassCode);

    int updateByPrimaryKeySelective(MrFeeClassDict record);

    int updateByPrimaryKey(MrFeeClassDict record);
}