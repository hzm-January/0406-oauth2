package houzm.accumulation.oauth2.config;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * Author: hzm_dream@163.com
 * Date:  2018/11/16 17:52
 * Modified By:
 * Description：客户端 auth2配置
 */
@Configuration
@EnableOAuth2Client
public class ClientOAuth2Config extends ResourceServerConfigurerAdapter {
    /*@Autowired
    private OAuth2ClientProperties oAuth2ClientProperties;

    @Autowired
    private AuthorizationServerProperties authorizationServerProperties;

    @Bean
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setCheckTokenEndpointUrl(authorizationServerProperties.getCheckTokenAccess());
        remoteTokenServices.setClientId(oAuth2ClientProperties.getClientId());
        remoteTokenServices.setClientSecret(oAuth2ClientProperties.getClientSecret());
        remoteTokenServices.setAccessTokenConverter(accessTokenConverter());
        return remoteTokenServices;
    }

    @Bean
    public AccessTokenConverter accessTokenConverter() {
        return new DefaultAccessTokenConverter();
    }*/

    @Bean
    public OAuth2ClientContextFilter oauth2ClientContextFilter() {
        OAuth2ClientContextFilter filter = new OAuth2ClientContextFilter();
        return filter;
    }

//    @Bean
//    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
//    protected AccessTokenRequest accessTokenRequest(@Value("#{request.parameterMap}")
//                                                            Map<String, String[]> parameters, @Value("#{request.getAttribute('currentUri')}")
//                                                            String currentUri) {
//        DefaultAccessTokenRequest request = new DefaultAccessTokenRequest(parameters);
//        request.setCurrentUri(currentUri);
//        return request;
//    }

    @Configuration
    protected static class OAuth2ClientContextConfiguration {

        @Resource
        @Qualifier("accessTokenRequest")
        private AccessTokenRequest accessTokenRequest;

        @Bean
        @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
        public OAuth2ClientContext oauth2ClientContext() {
            return new DefaultOAuth2ClientContext(accessTokenRequest);
        }

    }


}
