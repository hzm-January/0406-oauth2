package houzm.accumulation.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Package: houzm.accumulation.oauth2.config
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/4 11:55
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： WebSecurityConfig
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder()) //必须使用加密方式，如果不使用：There is no PasswordEncoder mapped for the id "null"
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("ADMIN")
            .and() //配置多用户
                .withUser("hzm")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //以下两种方式得到的结果相同
        // return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return new BCryptPasswordEncoder();
    }


//    @Override
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//        // ensure the passwords are encoded properly
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(users.username("user").password("password").roles("USER").build());
//        manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
//        return manager;
//    }
}
