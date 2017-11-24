package cn.bayllech.project.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-24 16:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    
    @Autowired
    private MailService mailService;
    
    @Test
    public void sendSimpleMail() throws Exception {
        mailService.sendSimpleMail("hpuqibei@163.com","test send mail"," Hello this is simple mail from springboot!");
    }
    
}