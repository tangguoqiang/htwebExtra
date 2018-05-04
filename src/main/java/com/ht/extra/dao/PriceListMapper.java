package com.ht.extra.dao;

import com.ht.extra.pojo.comm.PriceList;

import java.util.List;

public interface PriceListMapper {
    int insert(PriceList record);

    int insertSelective(PriceList record);

    List<PriceList> selectPriceListForSG(String desc1, String desc2);

    PriceList selectPriceListForSY(String desc);

    PriceList selectPriceListForAdministration(String chargeItemClass, String chargeItemCode, String chargeItemSpec, String units);

    PriceList selectPriceListByDoctor(String inExpertID, String clinicLabel);

    PriceList selectPriceList(String clinicLabel);

    PriceList selectPriceListByClinicType(String clinicType);
}