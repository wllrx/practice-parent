package cn.wllsrx.zoe.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zoe
 **/
@Component
@PropertySource("classpath:test.yml")
@ConfigurationProperties(prefix = "my")
@Data
public class TestYml {

    private int age;
    private String name;
    private String email;
}
