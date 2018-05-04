package com.ht.extra.dao;

import com.ht.extra.pojo.medrec.QuestionMrRecord;
import com.ht.extra.pojo.medrec.QuestionMrRecordKey;

public interface QuestionMrRecordMapper {
    int deleteByPrimaryKey(QuestionMrRecordKey key);

    int insert(QuestionMrRecord record);

    int insertSelective(QuestionMrRecord record);

    QuestionMrRecord selectByPrimaryKey(QuestionMrRecordKey key);

    int updateByPrimaryKeySelective(QuestionMrRecord record);

    int updateByPrimaryKey(QuestionMrRecord record);
}