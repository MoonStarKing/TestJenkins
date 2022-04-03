package com.example.demojenkins.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Slf4j
//@Component
//public class MyTask implements SchedulingConfigurer {
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.addTriggerTask(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(123);
//            }
//        }, new Trigger() {
//            @Override
//            public Date nextExecutionTime(TriggerContext triggerContext) {
//                CronTrigger cronTrigger = new CronTrigger("*/2 * * * * ? ");
//                return cronTrigger.nextExecutionTime(triggerContext);
//            }
//        });
//    }
//}
