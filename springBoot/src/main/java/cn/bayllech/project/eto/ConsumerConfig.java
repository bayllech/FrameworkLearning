package cn.bayllech.project.eto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-21 13:11
 */
//@ConfigurationProperties(prefix = "consumer.bayllech")
@Component
public class ConsumerConfig {

    @Value("${consumer.bayllech.domain}")
    String domain;
    @Value("${consumer.bayllech.port}")
    String port;
    
    public String getDomain() {
        return domain;
    }
    
    public void setDomain(String domain) {
        this.domain = domain;
    }
    
    public String getPort() {
        return port;
    }
    
    public void setPort(String port) {
        this.port = port;
    }
}
