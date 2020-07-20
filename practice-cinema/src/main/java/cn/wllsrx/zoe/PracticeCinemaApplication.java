package cn.wllsrx.zoe;

import cn.gjing.tools.swagger.core.EnableSingleDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author zoe
 */
@SpringBootApplication
@EnableSingleDoc
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class PracticeCinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeCinemaApplication.class, args);
    }

}
