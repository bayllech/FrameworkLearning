package cn.bayllech.project.eto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-21 13:33
 */
@Configuration  //@Component
@PropertySource("classpath:config.properties")
@ConfigurationProperties(prefix = "spring.dubbo")
public class ConfigProperties {

    String appname;
    String registry;
    String protocol;
    
    public String getAppname() {
        return appname;
    }
    
    public void setAppname(String appname) {
        this.appname = appname;
    }
    
    public String getRegistry() {
        return registry;
    }
    
    public void setRegistry(String registry) {
        this.registry = registry;
    }
    
    public String getProtocol() {
        return protocol;
    }
    
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
