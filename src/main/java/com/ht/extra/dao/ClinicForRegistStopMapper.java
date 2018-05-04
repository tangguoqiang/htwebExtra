package com.ht.extra.dao;

import com.ht.extra.pojo.outpadm.ClinicForRegistStop;
import com.ht.extra.pojo.outpadm.ClinicForRegistStopKey;
import java.util.List;

public abstract interface ClinicForRegistStopMapper
{
    public abstract int deleteByPrimaryKey(ClinicForRegistStopKey paramClinicForRegistStopKey);

    public abstract int insert(ClinicForRegistStop paramClinicForRegistStop);

    public abstract int insertSelective(ClinicForRegistStop paramClinicForRegistStop);

    public abstract ClinicForRegistStop selectByPrimaryKey(ClinicForRegistStopKey paramClinicForRegistStopKey);

    public abstract int updateByPrimaryKeySelective(ClinicForRegistStop paramClinicForRegistStop);

    public abstract int updateByPrimaryKey(ClinicForRegistStop paramClinicForRegistStop);

    public abstract List<ClinicForRegistStop> selectByClinicDate(String paramString);
}
