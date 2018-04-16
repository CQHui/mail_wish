package com.qihui.mailwish.dao;

import com.qihui.mailwish.model.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * create by chenqihui on 2018/4/5
 */
@Repository
public interface UserMapper {
    List<UserDO> getUsers();
}
