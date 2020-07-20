package cn.wllsrx.zoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zoe
 */
@SpringBootApplication
@EnableEurekaClient
public class PracticeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeApiApplication.class, args);
    }

}
