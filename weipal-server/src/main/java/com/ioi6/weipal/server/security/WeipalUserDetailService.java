package com.ioi6.weipal.server.security;

import com.ioi6.weipal.database.user.UserService;
import com.ioi6.weipal.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * security user
 * Created by shicheng on 2017/5/11.
 */
@Component
@Slf4j
public class WeipalUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("validate [{}] login status", username);
        // TODO: add user split user and amdin
        User user = userService.getByUserName(username);
        if (user == null) {
            log.info("user [{}] not found.", username);
            throw new UsernameNotFoundException("user not found");
        }
        return convertToUserDetail(user);
    }

    private UserDetails convertToUserDetail(User user) {
        List<GrantedAuthority> authorityList = getUserAuthorities(user);
        WeipalUserDetail userDetails = new WeipalUserDetail(user.getEmail(), user.getPassword(), authorityList);
        userDetails.setUser(user);
        return userDetails;
    }

    /**
     * @param user
     * @return
     */
    private List<GrantedAuthority> getUserAuthorities(User user) {
        GrantedAuthority authority = new SimpleGrantedAuthority("dev");
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(authority);
        return authorityList;
    }

}
