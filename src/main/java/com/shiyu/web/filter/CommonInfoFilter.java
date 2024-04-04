package com.shiyu.web.filter;

import com.shiyu.web.model.CommonConstants;
import jakarta.servlet.*;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.UUID;

public class CommonInfoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MDC.put(CommonConstants.TID, UUID.randomUUID().toString());
        filterChain.doFilter(servletRequest,servletResponse);
        MDC.remove(CommonConstants.TID);
    }

}
