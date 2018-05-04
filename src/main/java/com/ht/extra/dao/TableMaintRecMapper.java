package com.ht.extra.dao;

import com.ht.extra.pojo.comm.TableMaintRec;
import com.ht.extra.pojo.comm.TableMaintRecKey;

public interface TableMaintRecMapper {
    int deleteByPrimaryKey(TableMaintRecKey key);

    int insert(TableMaintRec record);

    int insertSelective(TableMaintRec record);

    TableMaintRec selectByPrimaryKey(TableMaintRecKey key);

    int updateByPrimaryKeySelective(TableMaintRec record);

    int updateByPrimaryKey(TableMaintRec record);
}