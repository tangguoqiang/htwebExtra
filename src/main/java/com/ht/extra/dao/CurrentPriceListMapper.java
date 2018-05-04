package com.ht.extra.dao;

import com.ht.extra.pojo.comm.CurrentPriceList;

import java.util.List;

public interface CurrentPriceListMapper {
    int insert(CurrentPriceList record);

    int insertSelective(CurrentPriceList record);

    CurrentPriceList selectByItemClassAndCode();

    List<CurrentPriceList> selectByInputCode(String feePy);

    List<CurrentPriceList> selectByInputCodeForDrug(String feePy);

    CurrentPriceList selectByPrimaryKey(String i, String s, String s1, String units);
}