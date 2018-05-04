package com.ht.extra.dao;

import com.ht.extra.pojo.RecordNo;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/17.
 */
public interface RecordNoMapper {

    List<RecordNo> selectPerformedByListForSG(Short visitNo, Date visitDate, String type);
}
