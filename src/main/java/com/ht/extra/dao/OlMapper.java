package com.ht.extra.dao;

import com.ht.extra.pojo.outln.OlWithBLOBs;

public interface OlMapper {
    int insert(OlWithBLOBs record);

    int insertSelective(OlWithBLOBs record);
}