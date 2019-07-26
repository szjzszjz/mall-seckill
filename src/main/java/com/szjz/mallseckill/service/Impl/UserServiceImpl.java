package com.szjz.mallseckill.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szjz.mallseckill.context.base.BaseServiceImpl;
import com.szjz.mallseckill.entity.User;
import com.szjz.mallseckill.dao.UserMapper;
import com.szjz.mallseckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

/**
 * author:szjz
 * date:2019/7/25
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}
