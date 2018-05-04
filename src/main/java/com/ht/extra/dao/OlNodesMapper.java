package com.ht.extra.dao;

import com.ht.extra.pojo.outln.OlNodes;

public interface OlNodesMapper {
    int insert(OlNodes record);

    int insertSelective(OlNodes record);
}