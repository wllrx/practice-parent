package cn.wllsrx.zoe.config;

import com.onesports.framework.auth.AuthorizationListener;
import com.onesports.framework.auth.metadata.AuthorizationMetaData;
import com.onesports.framework.auth.metadata.DefaultAuthorizationMetaData;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author zoe
 **/
@Configuration
public class AuthConfig implements AuthorizationListener {

    @Override
    public AuthorizationMetaData supplyAccess(String token) {
        DefaultAuthorizationMetaData authorizationMetaData = new DefaultAuthorizationMetaData();
        authorizationMetaData.addPermission("add");
        authorizationMetaData.addRole("admin");
        return authorizationMetaData;
    }

    @Override
    public void authentication(String s) {
        System.out.println(s);
    }

    @Override
    public void authenticationSuccess(HttpServletRequest request, Method method) {


    }


}

