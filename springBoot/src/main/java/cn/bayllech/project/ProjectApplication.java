package cn.bayllech.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableConfigurationProperties({ConsumerConfig.class})
public class ProjectApplication{
   
    
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }
}
