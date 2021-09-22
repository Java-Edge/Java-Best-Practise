package com.javaedge.task;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Collection;

/**
 * @author JavaEdge
 * @date 2022/4/17
 */
public class MyJobSche {

    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("javaedge", "java")
                .usingJobData("day", 1)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2).repeatForever())
                .build();
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        // 绑定关系 1：N
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
