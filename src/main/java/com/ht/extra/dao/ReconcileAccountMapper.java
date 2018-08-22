package com.ht.extra.dao;

import com.ht.extra.pojo.ReconcileAccount;

import java.util.List;

/**
 * 对账记录mapper
 * @author Tang
 */
public interface ReconcileAccountMapper {

    /**
     * 对账接口
     * @param startDate 对账开始日期
     * @param endDate 对账结束日期
     * @return 对账信息
     */
    List<ReconcileAccount> reconcileAccount(String startDate,String endDate);
}
