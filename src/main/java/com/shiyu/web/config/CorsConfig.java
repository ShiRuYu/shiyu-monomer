package com.shiyu.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //请求处理的地址
        registry.addMapping("/**")
                //允许的域
                .allowedOriginPatterns("*")
                //允许的请求方法
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                //允许的请求头
                .allowedHeaders("*")
                //浏览器是否发送凭证信息，如Cookie
                .allowCredentials(true)
                //预检请求有效期
                .maxAge(3600)
                //那些响应头可以作为响应暴露出来
                .exposedHeaders("*");
    }
}