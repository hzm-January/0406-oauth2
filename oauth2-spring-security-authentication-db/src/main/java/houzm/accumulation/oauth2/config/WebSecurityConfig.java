package houzm.accumulation.oauth2.config;

import houzm.accumulation.oauth2.service.TSystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Package: houzm.accumulation.oauth2.config
 * Author: houzm
 * Date: Created in 2018/11/3 15:04
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： MvcConfig
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TSystemUserService systemUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests() //定义需要保护的url和不需要保护的url
                .antMatchers("/signup", "/registry", "/","/index").permitAll()
                .anyRequest().authenticated() //所有请求必须登录后访问
                .and()
                    .formLogin()
                    .loginPage("/signin")
                    .loginProcessingUrl("/login") //必须配置，如果不配置前端请求login不进行认证
//                    .usernameParameter("username")
//                    .passwordParameter("password")
//                    .defaultSuccessUrl("/limit")
                    .failureUrl("/signin?error")
                    .permitAll() //登录界面，错误界面可以直接访问
                .and()
                    .logout()
                .logoutUrl("/out")
                .logoutSuccessUrl("/signin")
                    .permitAll(); //注销请求可直接访问
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //以下两种方式得到的结果相同
        // return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(systemUserService).passwordEncoder(passwordEncoder());
    }
}
