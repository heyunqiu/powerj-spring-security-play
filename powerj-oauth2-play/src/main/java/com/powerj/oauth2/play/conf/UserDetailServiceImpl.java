package com.powerj.oauth2.play.conf;

import com.powerj.oauth2.play.service.PowerJUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>实现security获取用户信息接口</p>
 *
 * @author : Heyunqiu
 * @date :2022/6/20
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private PowerJUserService powerJUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> userOpt = powerJUserService.findByUsername(username);
        if(userOpt.isPresent()) {
            return userOpt.get();
        }
        throw new UsernameNotFoundException("username or password invalid!");
    }
}
