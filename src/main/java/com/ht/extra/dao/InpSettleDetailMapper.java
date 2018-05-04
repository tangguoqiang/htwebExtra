package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.InpSettleDetail;
import com.ht.extra.pojo.inpbill.InpSettleDetailKey;

public interface InpSettleDetailMapper {
    int deleteByPrimaryKey(InpSettleDetailKey key);

    int insert(InpSettleDetail record);

    int insertSelective(InpSettleDetail record);

    InpSettleDetail selectByPrimaryKey(InpSettleDetailKey key);

    int updateByPrimaryKeySelective(InpSettleDetail record);

    int updateByPrimaryKey(InpSettleDetail record);
}