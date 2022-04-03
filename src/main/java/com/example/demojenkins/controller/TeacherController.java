package com.example.demojenkins.controller;

import com.example.demojenkins.common.R;
import com.example.demojenkins.entity.Teacher;
import com.example.demojenkins.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

@RestController
@RequestMapping("")
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> schedule;

    @PostMapping("/save")
    public R doSo(@RequestBody Teacher m){
        teacherMapper.insert(m);
        List<Teacher> teachers = teacherMapper.selectList(null);
        System.out.println(teachers);
        String a = "aaddb";

        schedule = threadPoolTaskScheduler.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("日日思君不见君，共饮长江水");
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger cronTrigger = new CronTrigger("*/3 * * * * *");
                return cronTrigger.nextExecutionTime(triggerContext);
            }
        });

        return R.ok();
    }
}
