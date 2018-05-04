package com.ht.extra.dao;

import com.ht.extra.pojo.comm.BillPatternDetail;
import com.ht.extra.pojo.comm.BillPatternDetailKey;

public interface BillPatternDetailMapper {
    int deleteByPrimaryKey(BillPatternDetailKey key);

    int insert(BillPatternDetail record);

    int insertSelective(BillPatternDetail record);

    BillPatternDetail selectByPrimaryKey(BillPatternDetailKey key);

    int updateByPrimaryKeySelective(BillPatternDetail record);

    int updateByPrimaryKey(BillPatternDetail record);
}