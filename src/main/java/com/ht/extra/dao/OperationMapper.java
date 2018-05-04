package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.Operation;
import com.ht.extra.pojo.medrec.OperationKey;

import java.util.List;

public interface OperationMapper {
    int deleteByPrimaryKey(OperationKey key);

    int insert(Operation record);

    int insertSelective(Operation record);

    Operation selectByPrimaryKey(OperationKey key);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKey(Operation record);

    List<Operation> selectByPatient(OperationKey key);
}