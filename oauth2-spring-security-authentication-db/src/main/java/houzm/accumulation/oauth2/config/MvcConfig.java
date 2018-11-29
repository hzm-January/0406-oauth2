package houzm.accumulation.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Package: houzm.accumulation.oauth2.config
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/3 17:23
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： MvcConfig
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/signin").setViewName("signin");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/limit").setViewName("limit");
        registry.addViewController("/").setViewName("index");
    }
}
