package com.shiyu.web.config;


import com.shiyu.web.filter.CommonInfoFilter;
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
