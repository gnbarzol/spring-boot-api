package com.platzi.makert.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlatziUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Esto es un test, realmente deberiamos llamar un servicio que verifique el user en la base o otra api
//        Se usa {noop} porque la clave no esta encriptada
        com.platzi.makert.domain.User user = userService.getByUsername(username).get();

        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
