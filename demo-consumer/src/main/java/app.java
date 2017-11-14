import cn.bayllech.service.UserInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-13 10:33
 */
public class app {
    
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.start();
        UserInfoService userInfoService = (UserInfoService) context.getBean("userInfoServiceImpl");
        System.out.println("dubbo consumer 调用成功： " + userInfoService.selectTotal(0,10));
        
        
    }
}
