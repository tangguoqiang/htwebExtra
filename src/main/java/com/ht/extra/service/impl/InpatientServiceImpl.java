package com.ht.extra.service.impl;

import com.ht.extra.dao.InpatientMapper;
import com.ht.extra.pojo.Inpatient;
import com.ht.extra.service.InpatientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Dell on 2016/7/14.
 */
@Service("InpatientService")
public class InpatientServiceImpl implements InpatientService {

    @Resource
    private InpatientMapper inpatientMapper;
    @Override
    public Inpatient getInpatientByIpid(String ipid) {
        return this.inpatientMapper.selectByPrimaryKey(ipid);
    }

    @Override
    public List<Inpatient> getInpaientsByOutTime(String time1, String time2) {
        return this.inpatientMapper.selectByOutTime(time1,time2);
    }

}
