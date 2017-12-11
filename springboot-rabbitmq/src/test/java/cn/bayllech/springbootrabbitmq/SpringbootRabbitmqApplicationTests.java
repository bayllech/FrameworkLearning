package cn.bayllech.springbootrabbitmq;

import cn.bayllech.springbootrabbitmq.send.RabbitSend;
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
    
    @Test
    public void hello() throws Exception {
        rabbitSend.send();
    }

}
