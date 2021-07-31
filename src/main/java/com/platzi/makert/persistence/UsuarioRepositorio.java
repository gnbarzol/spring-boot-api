package com.platzi.makert.persistence;

import com.platzi.makert.domain.User;
import com.platzi.makert.domain.repository.UserRepository;
import com.platzi.makert.persistence.crud.UsuarioCrudRepository;
import com.platzi.makert.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepositorio implements UserRepository {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return usuarioCrudRepository.findByUsername(username)
                .map(usuario -> userMapper.toUser(usuario));
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toUser(usuarioCrudRepository.save(userMapper.toUsuario(user)));
    }
}
