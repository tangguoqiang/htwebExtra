package com.ht.extra.dao;

import com.ht.extra.pojo.RecpNo;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/17.
 */
public interface RecpNoMapper {
    RecpNo selectRecpNo();
    RecpNo selectPatientID();
    RecpNo selectScanPay();
    RecpNo selectVisitNo();

}
