package cn.wllsrx.zoe.filter;

import cn.gjing.tools.common.result.ErrorResult;
import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author zoe
 **/
@Component
public class PracticeFilter extends ZuulFilter {
    Gson gson = new Gson();
    /**
     * 过滤类型
     *
     * @return String
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤顺序
     *
     * @return int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否过滤
     *
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String uri = request.getRequestURI();
        return !uri.contains("/v2/api-docs") && !uri.contains("/public");
    }

    /**
     * 业务逻辑
     *
     * @return Object
     * @throws ZuulException 异常
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();
        response.setContentType("application/json; charset=utf-8");
        //获取所有请求头
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName+"------------"+request.getHeader(headerName));
        }
        //获取请求参数
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            System.out.println(s+"======================="+request.getParameter(s));
            System.out.println("请求参数的参数值数组:"+"------------"+Arrays.toString(request.getParameterValues(s)));
        }
        System.out.println("请求的uri:"+request.getRequestURI());
        System.out.println("请求的url:"+request.getRequestURL() );
        System.out.println("请求方式: "+request.getMethod());
        System.out.println("请求地址:"+request.getServerName());
        System.out.println("请求端口"+request.getServerPort());
        String token = request.getHeader("token");
        if (token == null) {
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            context.setResponseBody(gson.toJson(ErrorResult.error("当前未登录,请先登陆!")));
            context.setSendZuulResponse(false);
            context.setResponse(response);
        }
        return null;
    }
}
