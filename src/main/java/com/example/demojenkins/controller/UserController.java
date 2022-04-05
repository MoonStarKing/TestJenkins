package com.example.demojenkins.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demojenkins.common.JwtUtil;
import com.example.demojenkins.common.R;
import com.example.demojenkins.entity.User;
import com.example.demojenkins.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liuxinlong
 * @since 2021-12-29
 */
@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil j;

    @PostMapping("/login")
    public R getUser(@RequestBody Map<String,String> user){
        String username = user.get("username");
        String password = user.get("password");

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);

        User one = userService.getOne(queryWrapper);
        if(one!=null && one.getPassword().equals(password)){
            System.out.println("成功");
            return R.ok().data("msg","登录成功");
        }

        return R.ok().data("err","登录失败");
    }

    @GetMapping("/getSome")
    public R getSome(){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken();
        subject.login(usernamePasswordToken);
        return R.ok();
    }

    @PostMapping("/doSome")
    public R doSome(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("id", 1);

        User one = userService.getOne(queryWrapper);

        Map<String,Object>resultMap = new HashMap();
        resultMap.put("name",one.getUsername());

        return R.ok().data("userMessage",resultMap);
    }
}

