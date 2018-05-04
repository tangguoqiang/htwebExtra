package com.ht.extra.dao;

import com.ht.extra.pojo.inpbill.DailyLedger;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
public interface DailyLedgerMapper {
    List<DailyLedger> selectDailyLedger(String paitentId, short visitId, Date beg, Date end);
}
