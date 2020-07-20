package cn.wllsrx.zoe.mapapi;

import cn.gjing.http.HttpClient;
import cn.gjing.http.HttpMethod;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zoe
 **/
public class MapTest {

    @Value("${map.key}")
    private String key;

    public static void main(String[] args) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("key","5b325c4bfff976dc906c0cb6181ae998");
        param.put("keywords","体育馆");
        param.put("types","080000");
        HttpClient.builder("https://restapi.amap.com/v3/place/text", HttpMethod.GET, String.class)
                .param(param)
                .execute()
                .listener(System.out::println);

    }
}
