package com.ht.extra.dao;

import com.ht.extra.pojo.comm.MdcRouteMatchResult;

public interface MdcRouteMatchResultMapper {
    int insert(MdcRouteMatchResult record);

    int insertSelective(MdcRouteMatchResult record);
}