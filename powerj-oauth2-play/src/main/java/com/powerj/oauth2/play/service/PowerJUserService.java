package com.powerj.oauth2.play.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>模拟项目中真实用户service层</p>
 *
 * @author : Heyunqiu
 * @date :2022/6/20
 **/
@Service
public class PowerJUserService {
    /**
     * 用户列表 这里直接在构造器里伪造 内存中存储
     */
    private List<UserDetails> userList;

    public PowerJUserService() {
        userList = new ArrayList<UserDetails>() {{
            add(User.builder().username("admin").password("admin").authorities("admin").build());
            add(User.builder().username("powerj-client").password("powerj-client").authorities("client").build());
        }};
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public Optional<UserDetails> findByUsername(String username) {
        return userList.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
}
