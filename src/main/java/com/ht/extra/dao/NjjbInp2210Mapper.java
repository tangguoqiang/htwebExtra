package com.ht.extra.dao;

import com.ht.extra.pojo.insurance.NjjbInp2210;
import com.ht.extra.pojo.insurance.NjjbInp2210Key;

public interface NjjbInp2210Mapper {
    int deleteByPrimaryKey(NjjbInp2210Key key);

    int insert(NjjbInp2210 record);

    int insertSelective(NjjbInp2210 record);

    NjjbInp2210 selectByPrimaryKey(NjjbInp2210Key key);

    int updateByPrimaryKeySelective(NjjbInp2210 record);

    int updateByPrimaryKey(NjjbInp2210 record);
}