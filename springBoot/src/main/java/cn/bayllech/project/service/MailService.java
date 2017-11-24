package cn.bayllech.project.service;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-24 16:52
 */
public interface MailService {
    public void sendSimpleMail(String to, String subject, String content);
}
