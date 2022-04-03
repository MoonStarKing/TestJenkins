package com.example.demojenkins.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demojenkins.entity.Teacher;
import com.example.demojenkins.mapper.TeacherMapper;
import com.example.demojenkins.service.TeacherService;
import org.springframework.stereotype.Service;

//无法读取是因为没有交给spring容器少了@Service
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper,Teacher> implements TeacherService {
}
