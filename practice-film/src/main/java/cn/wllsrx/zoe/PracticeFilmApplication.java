package cn.wllsrx.zoe;

import cn.gjing.tools.swagger.core.EnableSingleDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zoe
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableSingleDoc
public class PracticeFilmApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeFilmApplication.class, args);
    }

}
