package com.example.demojenkins.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demojenkins.entity.User;
import com.example.demojenkins.mapper.UserMapper;
import com.example.demojenkins.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
