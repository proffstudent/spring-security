package com.ogorodov.secure.service;

import com.ogorodov.secure.entity.User;
import com.ogorodov.secure.entity.enums.UserRoleEnum;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserDetailsServiceImpl implements  UserDetailsService {

    public String mes = "";

    @Autowired
    private UserService userService;

    @Autowired
    private LevelService levelService;
    private static Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getUser(login);
        logger.trace("userByUserName " + user.getName());
        logger.trace("levelByUserName " + levelService.getUserAccessById(user.getId()));
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(levelService.getUserAccessById(user.getId())));
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
        return userDetails;
    }

}
