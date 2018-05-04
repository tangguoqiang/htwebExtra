package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.MrBorrow;
import com.ht.extra.pojo.medrec.MrBorrowKey;

public interface MrBorrowMapper {
    int deleteByPrimaryKey(MrBorrowKey key);

    int insert(MrBorrow record);

    int insertSelective(MrBorrow record);

    MrBorrow selectByPrimaryKey(MrBorrowKey key);

    int updateByPrimaryKeySelective(MrBorrow record);

    int updateByPrimaryKey(MrBorrow record);
}