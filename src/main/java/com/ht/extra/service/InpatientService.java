package com.ht.extra.service;

import com.ht.extra.pojo.Inpatient;

import java.util.List;

/**
 * Created by Dell on 2016/7/14.
 */
public interface InpatientService {
    Inpatient getInpatientByIpid(String ipid);
    List<Inpatient> getInpaientsByOutTime(String time1,String time2);

}
