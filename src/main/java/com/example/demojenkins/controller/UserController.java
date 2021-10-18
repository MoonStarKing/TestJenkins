package com.example.demojenkins.controller;

import com.example.demojenkins.common.R;
import com.example.demojenkins.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class UserController {

    @GetMapping("/getSome")
    public R sayHi(){
        User user = new User();
        user.setName("石原里美");
        user.setName("18");

        return R.ok().data("msg","请求成功");
    }
}
