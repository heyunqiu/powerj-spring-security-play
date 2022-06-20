package com.powerj.oauth2.play.conf;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;

/**
 * <p>资源服务器</p>
 *
 * @author : Heyunqiu
 * @date :2022/6/20
 **/
public class ResourceServerConfig extends ResourceServerConfiguration {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .requestMatchers()
                .antMatchers("/user/**");
    }
}
