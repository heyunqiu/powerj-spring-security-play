package com.powerj.oauth2.play.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>测试用户信息接口</p>
 *
 * @author : Heyunqiu
 * @date :2022/6/20
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/currentUser")
    public Object currentUser(Authentication authentication){
        return authentication.getPrincipal();
    }
}
