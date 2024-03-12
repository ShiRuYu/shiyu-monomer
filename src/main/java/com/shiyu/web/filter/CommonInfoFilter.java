package com.shiyu.web.filter;

import com.shiyu.model.CommonConstants;
import com.shiyu.utils.CommonThreadInfoUtil;
import jakarta.servlet.*;
import org.apache.catalina.connector.RequestFacade;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.UUID;

public class CommonInfoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CommonThreadInfoUtil.set(CommonThreadInfoUtil.URI, ((RequestFacade) servletRequest).getRequestURI());
        CommonThreadInfoUtil.set(CommonThreadInfoUtil.REQUEST, servletRequest);
        CommonThreadInfoUtil.set(CommonThreadInfoUtil.RESPONSE, servletResponse);
        MDC.put(CommonConstants.TID, UUID.randomUUID().toString());
        filterChain.doFilter(servletRequest,servletResponse);
        CommonThreadInfoUtil.refresh();
        MDC.remove(CommonConstants.TID);
    }

}
