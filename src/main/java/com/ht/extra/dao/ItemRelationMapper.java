package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.ItemRelation;

import java.util.List;

public interface ItemRelationMapper {
    int insert(ItemRelation record);

    int insertSelective(ItemRelation record);

    List<ItemRelation> selectItemList();
}