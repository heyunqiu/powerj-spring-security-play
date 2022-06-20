package com.powerj.oauth2.play.conf;

import com.powerj.oauth2.play.service.PowerJClientService;
import com.powerj.oauth2.play.service.PowerJUserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * <p>服务器端配置</p>
 *
 * @author : Heyunqiu
 * @date :2022/6/20
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private PowerJClientService powerJClientService;
    private AuthenticationManager authenticationManager;
    private UserDetailServiceImpl userDetailService;

    public AuthorizationServerConfig(PowerJClientService powerJClientService,
                                     AuthenticationManager authenticationManager,
                                     UserDetailServiceImpl userDetailService) {
        this.powerJClientService = powerJClientService;
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(powerJClientService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).userDetailsService(userDetailService);
    }
}
