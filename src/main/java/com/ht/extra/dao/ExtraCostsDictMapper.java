package com.ht.extra.dao;

import com.ht.extra.pojo.comm.ExtraCostsDict;
import com.ht.extra.pojo.comm.ExtraCostsDictKey;

public interface ExtraCostsDictMapper {
    int deleteByPrimaryKey(ExtraCostsDictKey key);

    int insert(ExtraCostsDict record);

    int insertSelective(ExtraCostsDict record);

    ExtraCostsDict selectByPrimaryKey(ExtraCostsDictKey key);

    int updateByPrimaryKeySelective(ExtraCostsDict record);

    int updateByPrimaryKey(ExtraCostsDict record);
}