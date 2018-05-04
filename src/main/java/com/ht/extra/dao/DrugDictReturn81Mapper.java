package com.ht.extra.dao;

import com.ht.extra.pojo.comm.DrugDictReturn81;
import com.ht.extra.pojo.comm.DrugDictReturn81Key;

public interface DrugDictReturn81Mapper {
    int deleteByPrimaryKey(DrugDictReturn81Key key);

    int insert(DrugDictReturn81 record);

    int insertSelective(DrugDictReturn81 record);

    DrugDictReturn81 selectByPrimaryKey(DrugDictReturn81Key key);

    int updateByPrimaryKeySelective(DrugDictReturn81 record);

    int updateByPrimaryKey(DrugDictReturn81 record);
}