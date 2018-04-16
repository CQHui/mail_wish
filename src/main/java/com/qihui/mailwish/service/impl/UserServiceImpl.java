package com.qihui.mailwish.service.impl;

import com.qihui.mailwish.dao.UserMapper;
import com.qihui.mailwish.model.UserDO;
import com.qihui.mailwish.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by chenqihui on 2018/4/5
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<UserDO> getUsers() {
        return userMapper.getUsers();
    }
}
