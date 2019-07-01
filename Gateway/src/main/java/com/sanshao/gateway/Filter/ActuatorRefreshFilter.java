package com.sanshao.gateway.Filter;


import com.netflix.client.http.HttpRequest;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.http.ServletInputStreamWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

//负责清空webhook中的payload
//@Component
public class ActuatorRefreshFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        String uri = httpServletRequest.getRequestURI();

        if (uri.endsWith("/actuator/refresh") || uri.endsWith("/actuator/bus-refresh")) {
            //清空payload
            System.out.println(uri);
            RequestContext context = getCurrentContext();
//            context.setRequest(new HttpServletRequestWrapper(context.getRequest()){
//                public ServletInputStream getInputStream() throws IOException {
//                    return new ServletInputStreamWrapper(new byte[0]);
//                }
//            });
            context.setRequest(new HttpServletRequestWrapper(getCurrentContext().getRequest()) {
                @Override
                public ServletInputStream getInputStream() throws IOException {
                    return new ServletInputStreamWrapper(new byte[0]);
                }

            });
            System.out.println("request="+httpServletRequest);
        }

        return null;
    }

}
