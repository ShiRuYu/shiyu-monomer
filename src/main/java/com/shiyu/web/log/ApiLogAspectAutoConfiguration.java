package com.shiyu.web.log;

import com.shiyu.web.log.aspect.ApiLogPointCut;
import com.shiyu.web.log.aspect.ServletApiLogInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * api切面配置
 */
@Configuration
@ConditionalOnClass(name = {"jakarta.servlet.Filter"})
public class ApiLogAspectAutoConfiguration{

    @Bean
    public ApiLogPointCut apiLogPointCut() {
        return new ApiLogPointCut();
    }

    @Bean
    public ServletApiLogInterceptor apiLogInterceptor() {
        return new ServletApiLogInterceptor();
    }

    /**
     * api日志切面
     *
     * @param apiLogInterceptor
     * @param apiLogPointCut
     * @return
     */
    @Bean
    public Advisor apiLogAdvisor(final ServletApiLogInterceptor apiLogInterceptor, final ApiLogPointCut apiLogPointCut) {
        DefaultBeanFactoryPointcutAdvisor apiLogAdvisor = new DefaultBeanFactoryPointcutAdvisor();
        apiLogAdvisor.setAdvice(apiLogInterceptor);
        apiLogAdvisor.setPointcut(apiLogPointCut);

        return apiLogAdvisor;
    }

}
