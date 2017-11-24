package cn.bayllech.project.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-24 16:36
 */
@Component
public class ScheduleTask1 {
    private int count=0;
    
    
    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
    
    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("schedule task 1 执行：  "+(count++));
    }
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
}
