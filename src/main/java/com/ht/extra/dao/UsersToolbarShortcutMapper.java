package com.ht.extra.dao;

import com.ht.extra.pojo.comm.UsersToolbarShortcut;

public interface UsersToolbarShortcutMapper {
    int deleteByPrimaryKey(Long shortcutId);

    int insert(UsersToolbarShortcut record);

    int insertSelective(UsersToolbarShortcut record);

    UsersToolbarShortcut selectByPrimaryKey(Long shortcutId);

    int updateByPrimaryKeySelective(UsersToolbarShortcut record);

    int updateByPrimaryKey(UsersToolbarShortcut record);
}