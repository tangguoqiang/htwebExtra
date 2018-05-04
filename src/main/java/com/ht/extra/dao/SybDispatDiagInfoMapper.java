package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.SybDispatDiagInfo;
import com.ht.extra.pojo.medrec.SybDispatDiagInfoKey;

public interface SybDispatDiagInfoMapper {
    int deleteByPrimaryKey(SybDispatDiagInfoKey key);

    int insert(SybDispatDiagInfo record);

    int insertSelective(SybDispatDiagInfo record);

    SybDispatDiagInfo selectByPrimaryKey(SybDispatDiagInfoKey key);

    int updateByPrimaryKeySelective(SybDispatDiagInfo record);

    int updateByPrimaryKey(SybDispatDiagInfo record);
}