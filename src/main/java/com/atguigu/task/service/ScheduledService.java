package com.atguigu.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    /**
     * second、minute、hour、day of month、month、day of week。
     * 0 * * * * MON-FRI
     * 【0 0/5 14,18 * * ?】 每天14点整，和18点整，每隔5分钟执行一次
     * 【0 15 10 ? * 1-6】    每个月的周一到周六10:15分执行一次
     * 【0 0 2 ? * 6L】   每个月的最后一个周六凌晨2点执行一次
     * 【0 0 2 LW * ?】   每个月的最后一个工作日凌晨2点执行一次
     * 【0 0 2-4 ? * 1#1】    每个月的第一个周一凌晨2点到4点期间，每个整点执行一次
     */
//    @Scheduled(cron = "0 * * * * MON-FRI")
//    @Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")
//    @Scheduled(cron = "0-4 * * * * MON-SAT")
    @Scheduled(cron = "0/4 * * * * MON-SAT")    //从0开始，每4秒启动一次
    public void hello(){
        System.out.println("Hello...");
    }
}
