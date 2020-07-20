package cn.wllsrx.zoe;

import cn.gjing.tools.common.cors.EnableCors;
import cn.gjing.tools.swagger.core.EnableGroupDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author zoe
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableGroupDoc
@EnableCors
public class PracticeZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeZuulApplication.class, args);
    }

}
