package cn.wllsrx.zoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zoe
 */
@EnableEurekaServer
@SpringBootApplication
public class PracticeEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeEurekaApplication.class, args);
    }

}
