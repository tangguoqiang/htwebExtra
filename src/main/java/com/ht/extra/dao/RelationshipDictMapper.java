package com.ht.extra.dao;

import com.ht.extra.pojo.comm.RelationshipDict;

public interface RelationshipDictMapper {
    int deleteByPrimaryKey(String relationshipCode);

    int insert(RelationshipDict record);

    int insertSelective(RelationshipDict record);

    RelationshipDict selectByPrimaryKey(String relationshipCode);

    int updateByPrimaryKeySelective(RelationshipDict record);

    int updateByPrimaryKey(RelationshipDict record);
}