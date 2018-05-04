package com.ht.extra.dao;

import com.ht.extra.pojo.exam.VExamReq;

public interface VExamReqMapper {
    int insert(VExamReq record);

    int insertSelective(VExamReq record);
}