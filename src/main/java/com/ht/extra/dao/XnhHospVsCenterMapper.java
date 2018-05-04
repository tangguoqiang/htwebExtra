package com.ht.extra.dao;

import com.ht.extra.pojo.comm.XnhHospVsCenter;
import com.ht.extra.pojo.comm.XnhHospVsCenterKey;

public interface XnhHospVsCenterMapper {
    int deleteByPrimaryKey(XnhHospVsCenterKey key);

    int insert(XnhHospVsCenter record);

    int insertSelective(XnhHospVsCenter record);

    XnhHospVsCenter selectByPrimaryKey(XnhHospVsCenterKey key);

    int updateByPrimaryKeySelective(XnhHospVsCenter record);

    int updateByPrimaryKey(XnhHospVsCenter record);
}