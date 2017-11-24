package cn.bayllech.project.service.impl;

import cn.bayllech.project.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-24 16:52
 */
@Service
public class MailServiceImpl implements MailService {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${mail.fromMail.addr}")
    private String from;
    
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        
        try {
            mailSender.send(message);
            logger.info(String.format("%s发送邮件至%s,主题：%s,内容：%s",from,to,subject,content));
        } catch (Exception e) {
            logger.error(String.format("%s发送邮件至%s异常,主题：%s,内容：%s",from,to,subject,content), e);
        }
        
    }
}
