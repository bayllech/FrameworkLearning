package cn.bayllech.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringcloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConfigClientApplication.class, args);
	}
	
    //    @Value("${server.port}") 当远程配置与本地配置存在同名属性，远程属性会覆盖本地属性
    @Value("${foo}")      String foo;
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
}
