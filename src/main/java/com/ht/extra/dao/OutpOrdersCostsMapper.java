package com.ht.extra.dao;

import com.ht.extra.pojo.outpdoct.OutpOrdersCosts;
import com.ht.extra.pojo.outpdoct.OutpOrdersCostsKey;

import java.util.Date;
import java.util.List;

public interface OutpOrdersCostsMapper {
    int deleteByPrimaryKey(OutpOrdersCostsKey key);

    int insert(OutpOrdersCosts record);

    int insertSelective(OutpOrdersCosts record);

    OutpOrdersCosts selectByPrimaryKey(OutpOrdersCostsKey key);

    List<OutpOrdersCosts> selectOrdersCostsList(String patientId, String changeType);

    OutpOrdersCosts  selectCountBySerialNo(String serialNo, Date visitDate, Short visitNo);

    OutpOrdersCosts  selectCountBySerialNo1(String serialNo);

    OutpOrdersCosts  selectOrdersCostsForOrderType(String serialNo);

    List<OutpOrdersCosts> selectOrdersCostsListBySerialNo(String serialNo, Date visitDate, Short visitNo);

    List<OutpOrdersCosts> selectOrdersCostsListBySerialNo1(String serialNo);

    List<OutpOrdersCosts> selectOrdersCostsListForPresc(String serialNo);

    int updateByPrimaryKeySelective(OutpOrdersCosts record);

    int updateByPrimaryKey(OutpOrdersCosts record);

    int updateIndicatorBySerialNo(String serialNo, String rcptNo);

    List<OutpOrdersCosts> selectOrdersCostsDeptForJY(Short visitNo, Date visitDate);

    List<OutpOrdersCosts> selectOrdersCostsDeleteForSG(Short visitNo, Date visitDate, String s160, String type1);

    List<OutpOrdersCosts> selectISOrdersCostsForYF(Date visitDate, Short visitNo, String patientId, String desc1, String desc2, String desc3);

    OutpOrdersCosts selectISOrdersCostsForDays(Date visitDate, Short visitNo, String patientId, String desc1, String desc2, String desc3);

    OutpOrdersCosts selectISOrdersCostsForJM(Date visitDate, Short visitNo, String patientId);

    OutpOrdersCosts selectISOrdersCostsForChildJM(Date visitDate, Short visitNo, String patientId);

    List<OutpOrdersCosts> selectISOrdersCostsForChildYF(Date visitDate, Short visitNo, String patientId, String desc);

    OutpOrdersCosts selectISOrdersCostsForChildDays(Date visitDate, Short visitNo, String patientId, String desc);

   // List<OutpOrdersCosts> selectOrdersCostsListForDeleteFC(String patientId, Date visitDate, Short visitNo);

    OutpOrdersCosts selectISOrdersCostsForMaxItemNo(Date visitDate, Short visitNo, String serialNo);

    List<OutpOrdersCosts> selectOrdersCostsDeptForSG(Short visitNo, Date visitDate, String type,String s160);

    void deleteOrdersCostsDeleteForSG(Short visitNo, Date visitDate);

    List<OutpOrdersCosts> selectOrdersCostsListByRecptNo(String recptNo);

    List<OutpOrdersCosts> selectOrdersCostsListForCXQ(Short visitNo, Date visitDate, String patientId);

    OutpOrdersCosts selectISOrdersCostsForMaxAmount(Date visitDate, Short visitNo,String desc, String patientId);
}