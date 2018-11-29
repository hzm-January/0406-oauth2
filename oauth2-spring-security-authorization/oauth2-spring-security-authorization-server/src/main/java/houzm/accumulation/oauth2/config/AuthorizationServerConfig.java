package houzm.accumulation.oauth2.config;

import houzm.accumulation.oauth2.util.PasswordEncoderUtil;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

/**
 * Package: houzm.accumulation.oauth2.config
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/4 19:21
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        // @formatter:off
        clients.inMemory().withClient("clientapp") //客户端用户名
                .authorizedGrantTypes("authorization_code", "refresh_token", "implicit")
                .authorities("ROLE_CLIENT")
                .scopes("read_info", "modify_info")
                .secret(PasswordEncoderUtil.passwordEncoder("secret")) //客户端密码
                .redirectUris("http://localhost:9001/callback");
//                .accessTokenValiditySeconds(60*30) // 30min
//                .refreshTokenValiditySeconds(60*60*24); // 24h
        // @formatter:on
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        //        oauthServer.checkTokenAccess("isAuthenticated()");
        oauthServer.checkTokenAccess("permitAll()");
        oauthServer.allowFormAuthenticationForClients();
    }



}