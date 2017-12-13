package cn.bayllech.springbootrabbitmq;

import cn.bayllech.springbootrabbitmq.send.RabbitSend;
import cn.bayllech.springbootrabbitmq.send.RabbitSend2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {
    
    @Test
    public void contextLoads() {
    }
    
    @Autowired
    private RabbitSend rabbitSend;
    @Autowired
    private RabbitSend2 rabbitSend2;
    
    @Test
    public void hello() throws Exception {
        rabbitSend.send();
    }
    
    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<100;i++){
            rabbitSend.send(i);
        }
    }
    
    @Test
    public void manyToMany() throws Exception {
        for (int i=0;i<100;i++){
            rabbitSend.send(i);
            rabbitSend2.send(i);
        }
    }
    
}
