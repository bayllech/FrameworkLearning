package cn.bayllech.springclould;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringClouldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringClouldApplication.class, args);
	}
}
