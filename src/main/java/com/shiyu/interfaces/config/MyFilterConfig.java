package com.shiyu.interfaces.config;


import com.shiyu.interfaces.filter.CommonInfoFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean<CommonInfoFilter> filterRegistrationBean(){
        FilterRegistrationBean<CommonInfoFilter> filterFilterRegistrationBean=
                new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new CommonInfoFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");
//        filterFilterRegistrationBean.setOrder(0); //决定注册的优先级
        return filterFilterRegistrationBean;
    }
}
