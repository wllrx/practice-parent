package cn.wllsrx.zoe;

import cn.gjing.tools.swagger.core.EnableSingleDoc;
import com.onesports.framework.auth.config.EnableAuthorization;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author zoe
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableSingleDoc
@EnableAuthorization
public class PracticeUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeUserApplication.class, args);
    }

}
